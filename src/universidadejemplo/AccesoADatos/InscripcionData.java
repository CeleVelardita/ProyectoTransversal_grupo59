/*
Esta clase además de poseer los métodos que permitirán hacer un CRUD sobre la tabla Inscripcion,
tiene métodos que permiten hacer operaciones un poco más complejas como el método
“obtenerMateriasCursadas”, que recibiendo el id del alumno, nos retornará las materias en las que
este está inscripto.

CRUD = Create, Read, Update, Delete (Crear, Leer, Actualizar, Eliminar)
*/
package universidadejemplo.AccesoADatos;

//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;

public class InscripcionData {
    private Connection con=null;
    private MateriaData md=new MateriaData();   
    private AlumnoData ad=new AlumnoData(); 
    
    /* ATENCIÓN!!!!!!!!!!!!!!
    esos 2 último objetos md y ad de tipo MateriaData y AlumnoData respectivamente
    son para poder utilizar los métodos de esas clases (estamos en la clase inscripcionData)
    a la hora de querer acceder a la base de datos y querer manipular las tablas para 
    recuperar la info deseada al recorrer la tabla en un while más adelante
    */
    
    public InscripcionData(){
        this.con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES(?,?,?)"; 
                   //3 valores que se llenan dinámicamente, entonces ponemos (?,?,?) como valores por parámetro
        try {
            //creo el acceso a la tabla con su respectivo catch porque puede saltar una Exception
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // Statement.RETURN_GENERATED_KEYS es una constante que necesitamos porque esperamos una clave
            
            //si no salta la exception es porque logró acceder a la tabla y puedo continuar
            //ahora mandaré las incripciones con un set
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
                        
            ps.executeUpdate();
            //voy a recibir claves que me confirmen que se pudo SETear y las guardo en un tipo result
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Registrada");
            }
            ps.close();        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción (método guardarInscripción)"+ex.getMessage());
        } 
        
      /*
      Para probar este método   guardarInscripcion(Inscripcion insc)
      tenemos que colocar en el main del proyecto la sentencia:
      guardarInscripcion(insc);
      donde insc será de tipo de la clase Inscripcion por lo que contendrá
      los atributos y forma de tal clase (de la carpeta entidades, modelo de la BD)
      */
    }
       
    public List<Inscripcion> obtenerInscripciones(){
        //Método que devuelve una lista de inscripciones
        ArrayList<Inscripcion> cursadas= new ArrayList<>(); //esta lista está vacía todavía
        
        String sql="SELECT * FROM inscripcion"; //pide todas las inscripciones
        /*
        en sql no pedimos solo las de estado activo = 1  porque 
        como el método que borra hace un borrado físico, es decir,
        trabaja directamente sobre inscripciones que están activas. 
        */

        //NOTA: ver sobre borrado Físico y Lógico, pro y contras
        try{
            //creo el acceso a la tabla
            PreparedStatement ps=con.prepareStatement(sql);
            /*
            como usamos SELECT en "SELECT * FROM inscripcion" es una executeQuery
            y me devuelve un valor ResultSet que almaceno en rs
            que constendrá tantas columnas y filas como tenga la tabla
            Luego lo recorreremos con un rs.next() dentro de un while
            */
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                Inscripcion insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu=ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                //ad.buscarAlumno pide el idAlumno
                //rs.getInt("idAlumno") obtiene el idAlumno y se lo pasa al método
                //Alumno alu (carpeta entidades) almacena el idAlumno obtenido
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                //md.buscarMateria pide el idMateria
                //rs.getInt("idMateria") obtiene el idMateria y se lo pasa al método
                //Materia mat (carpeta entidades) almacena el idAlumno obtenido
                
                //ahora seteamos en la tabla inscripcion con el insc
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                //ahora con estos datos armamos nuestra lista "cursadas" (ArrayList)
                cursadas.add(insc);
            }
            ps.close();//cierro petición
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (lista ObtenerInscripciones) "+ex.getMessage());
        }
        //Ahora devuelvo la lista cursadas a quien llamó a obtenerInscripciones() 
        return cursadas;
        //prueba en el main del proyecto
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        //Método que devuelve una lista de inscripciones
        ArrayList<Inscripcion> cursadas= new ArrayList<>(); //esta lista está vacía todavía
        
        String sql="SELECT * FROM inscripcion WHERE idAlumno=?"; 
        //con el WHERE idAlumno=? ya tengo un parámetro dinámico, antes del ResultSet debo setear el idAlumno con un ps.setInt(1, idAlumno)
        //NOTA: ver sobre borrado Físico y Lógico, pro y contras
        try{
            //creo el acceso a la tabla
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                Inscripcion insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu=ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                //ad.buscarAlumno pide el idAlumno
                //rs.getInt("idAlumno") obtiene el idAlumno y se lo pasa al método
                //Alumno alu (carpeta entidades) almacena el idAlumno obtenido
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                //md.buscarMateria pide el idMateria
                //rs.getInt("idMateria") obtiene el idMateria y se lo pasa al método
                //Materia mat (carpeta entidades) almacena el idAlumno obtenido
                
                //ahora seteamos en la tabla inscripcion con el insc
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                //ahora con estos datos armamos nuestra lista "cursadas" (ArrayList)
                cursadas.add(insc);
            }
            ps.close();//cierro petición
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (lista inscripciones por alumno) "+ex.getMessage());
        }
        //Ahora devuelvo la lista cursadas a quien llamó a obtenerInscripciones() 
        return cursadas;
        //prueba en el main del proyecto
        
    }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno){
        
        ArrayList<Materia> materias= new ArrayList();
        
        String sql= "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMateria "
                    +" AND inscripcion.idAlumno = ? ;";
        /*Necesitamos solo las materias donde el alumno está inscripto
        en el  FROM tengo un producto carteciano y no tengo JOIN, es decir,
        uno las tablas inscripcion y materia con una ","
        el producto carteciano unirá cada fila de inscripcion con cada fila
        de materia y sólo queremos el idAlumno y el idMAteria de c/tabla, asique
        en el WHERE coloco la condicion de union al no tener un JOIN
        luego en AND q' incriocion.idAlumno sea algo que pasa por parámetro "=?"       
        */
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno); //idAlumno pasado por parámetro
            ResultSet rs=ps.executeQuery();
            //Ahora comenzamos a recorrer
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                //ya obtuvimos los datos, ahora agregarlos a arraylist materias
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (lista materias cursadas) "+ex.getMessage());
        }
        
        return materias;   
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int idAlumno){
        ArrayList<Materia> materias= new ArrayList();
        
        String sql= "SELECT * FROM materia WHERE estado = 1 AND idMateria not in "
                    + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
        /*Explicación del sql
          subconsulta (SELECT idMateria FROM incripcion WHERE idAlumno=?) -> materias donde está inscripto el alumno
          SELECT * FROM materia -> pide todas las materias
          WHERE estado = 1 que esas materias tengan estado 1, estén activas  
          AND idMateria not in -> que no estén en la lista de materias donde el alumno esté insrcipto
        
        
          conclusión: pide todas las materias que estén activas 
          y NO se encuentren en la lista de materias donde el alumno esté inscripto
        */
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno); //idAlumno pasado por parámetro
            ResultSet rs=ps.executeQuery();
            //Ahora comenzamos a recorrer
            while(rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                //ya obtuvimos los datos, ahora agregarlos a arraylist materias
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (lista materias no crusadas) "+ex.getMessage());
        }
        
        return materias;
    }
     
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        //borrado físico
        String sql= "DELETE FROM inscripcion WHERE idAlumno =? and idMAteria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int filas=ps.executeUpdate(); //el executeUpdate devuelve un entero
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Inscripción Borrada");
            }
            
            //cerramos el borrarInscripcionMateriaAlumno
            ps.close();
            /*
            Para probar este mñetodo borrarInscripcionMateriaAlumno
            en el main del proyecto escribo una sentencia:
            id.borrarInscripcionMateriaAlumno(idAlumno, idMAteria)
            donde idAlumno es el alumno que deseo dar de baja 
            e id materia es el num. de materia 
            en el que estña inscripto ese alumno
            */
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de conexión a la BD"+ex.getMessage());
        }
        
    }
    
    public void actualizarNota (int idAlumno, int idMateria, double nota){
     
        String sql="UPDATE inscripcion SET nota = ? where idAlumno = ? and idMateria = ?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble( 1, nota);
            ps.setInt( 2, idAlumno);
            ps.setInt( 3, idMateria);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (acualizar nota) "+ex.getMessage());
        }
    /*
    Para probar este método actualizarNota(int idAlumno, int idMateria, double nota)
    debemos escribir en el main del proyecto la sig. sentencia(método):
    id.actualizarNota(idAlumno, idMateria, nota)
    donde recibirá por argumento:
        el id del Alumno
        el id de la materia de ese alumno
        la nota 
    */
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        ArrayList<Alumno> alumnosMateria=new ArrayList();
        
        String sql="SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
                   + "FROM inscripcion i, alumno a WHERE i.idAlumno= a.idAlumno AND idMateria=?";
        try {
            /*Explicación sql
            se desea unir la tabla inscribir con la tabla alumno
            colocamos alias:
            inscripcion i
            alumno a
            como no usamos JOIN debemos usar en el WHERE la condición de unión donde:
            i.idAlumno(clave foránea)= a.idALumno(clave primaria) -> idAlumno de tabla inscripcion = idAlumno tabla alumno
            AND idMateria=? -> recibe parámetro dinámico
            */
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (alumnos por materia) "+ex.getMessage());
        }
        
        
        return alumnosMateria;
    }
    
    
    
    /*-----------------------------------------------------------------------------------------------------------------*/
    
    
    /*APARTADO método para la vista AdministracionView_ManipulacionDeNotas*/
    public List<Inscripcion> obtenerNotasDeMaterias(int idAlumno){
        ArrayList<Inscripcion> inscripto= new ArrayList<>();
        
        String sql= "SELECT inscripcion.nota, materia.idMateria, materia.nombre " +
                 "FROM inscripcion " +
                 "INNER JOIN materia ON inscripcion.idMateria = materia.idMateria " +
                 "WHERE inscripcion.idAlumno = ?";
        /*Explicación del sql
        
          En resumen, esta consulta SQL está diseñada para obtener las notas (nota), los IDs de las materias (idMateria), 
        y los nombres de las materias (nombre) de la tabla inscripcion, relacionándolos con la tabla materia a través de la columna idMateria,
        y filtrando los resultados para un alumno específico a través de la columna idAlumno.
        
        
        "SELECT inscripcion.nota, materia.idMateria, materia.nombre ": 
        Esta parte especifica las columnas que se seleccionarán en la consulta.
        En este caso, se seleccionan tres columnas: nota de la tabla inscripcion, idMateria y nombre de la tabla materia.
        
        "FROM inscripcion ": Indica la tabla principal de la que se seleccionarán los datos, en este caso, la tabla inscripcion.
        
        "INNER JOIN materia ON inscripcion.idMateria = materia.idMateria ": 
        Esta parte realiza una unión (JOIN) entre las tablas inscripcion y materia. 
        Establece una relación entre estas dos tablas utilizando las columnas idMateria. 
        Esto significa que se obtendrán datos de ambas tablas basándose en la igualdad de los valores de idMateria en ambas tablas.
        
        "WHERE inscripcion.idAlumno = ?": Establece una condición para filtrar los resultados.
        Aquí, se seleccionarán solo las filas de la tabla inscripcion donde el valor de la columna idAlumno 
        sea igual al valor que se proporciona como parámetro (?). El ? es un marcador de posición que se llenará 
        con el valor real cuando se ejecute la consulta utilizando un PreparedStatement en Java. 
        Esto permite hacer la consulta específica para un alumno en particular.
        
        */
        try {
            PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno); // idAlumno pasado al parámetro dinámico
        ResultSet rs = ps.executeQuery(); // donde almacenamos la respuesta de la BD
        // Ahora comenzamos a recorrer
        while (rs.next()) {
            int idMateria = rs.getInt("idMateria");
            String nombreMateria = rs.getString("nombre");
            double nota = rs.getDouble("nota");
            
            // Crear un objeto Inscripcion con los datos obtenidos
            Inscripcion insc = new Inscripcion(idMateria, nombreMateria, nota);

            // Agregar insc a la lista
            inscripto.add(insc);
           
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción (notas por materia) "+ex.getMessage());
        }
        
        return inscripto;
    }
/*-----------------------------------------------------------------------------------------------------------------*/    

}
