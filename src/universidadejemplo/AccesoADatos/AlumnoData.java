
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
//import universidadejemplo.Vistas.Alumno;


public class AlumnoData {
    
    // Creo un atributo connection que va a ser utilizado por todos los métodos para poder implementar las funcionalidades CRUD
    private Connection con = null;
    
    public AlumnoData(){
        // Este constructor no recibe nada por parámetro y solo inicializa el objeto connection "con"
        con = Conexion.getConexion();
        // el método .getConexion es el que establece la conexión a la BD
    }
    
    // El método guardarAlumno hace un INSERT en la tabla Alumno
    
    public void guardarAlumno (Alumno alumno){
        // Se prepara la sentencia que se va a enviar a la BD
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                + "VALUES(?, ?, ?, ?, ?)"; // Van signos de pregunta porque van a ser reemplazados por lo que se ingrese en Alumno
        
        try{
        // Se genera el objeto prepareStatement el cual va a enviar esa sentencia a la BD
        // .conprepareStatement(sentenciaSql, le pido que devuelva la lista de las claves generadas ID)
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //Se setean los tipos de datos que quiero enviar, porque llegan el método a través del parámetro "alumno"
        ps.setInt(1, alumno.getDni());
        ps.setString(2, alumno.getApellido());
        ps.setString(3, alumno.getNombre());
        // La fecha de nacimiento no se puede enviar como un Local Date porque el PrepareStatement tiene el método Date
        // Luego hay que convertir el Local Date a un Date        
        ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
        ps.setBoolean(5, alumno.isActivo());
        
        // Una vez que se envían todas las sentencias se ejecutan
        ps.executeUpdate();
        
        // Luego se pide la clave generada al alumno
        // Devuelve una tabla, en este caso con una sola columna que es la dle ID, con tantas filas
        // com alumnos haya cargado        
        ResultSet claveAlumno = ps.getGeneratedKeys();
        // En este caso le manda un solo alumno por lo que no es necesario recorrer la lista con un while
        // el next me indica que pasa al siguiente renglón, entonces significa que lo pudo agregar
        if (claveAlumno.next()){
            alumno.setIdAlumno(claveAlumno.getInt(1));
            JOptionPane.showMessageDialog(null, "Alumno Guardado");
        }
        // Cierro el método prepareStatement
        ps.close();        
        
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
            
        }
    }
    
    //El método modificarAlumno hace un UPDATE en la tabla, lo modifica
    
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?"
                + "WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            //ps.setBoolean(5, alumno.isActivo());
            // Por último se setea el ID
            ps.setInt(5, alumno.getIdAlumno());

            //Luego ejecuto, RECORDAR QUE EL MÉTODO executeUpdate DEVUELVE UN ENTERO CON LA CANTIDAD DE FILAS ACEPTADAS
            int modificacion = ps.executeUpdate();

            // Creo un diálogo para que me muestre si se modificó correctamente
            if (modificacion == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }

    // El método eliminarAlumno genera el borrado a través de un operador lógico, se le modifica el estado
    // A diferencia de los otros dos métodos, recibe un entero, puede ser el dni o el id del alumno que deseo eliminar
    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        try {
            // UPDATE nombre_tabla SET atributo = lo que quiero poner WHERE clave_foránea
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Acá le digo que quiero que reemplace al id por ese id que le indiqué
            int eliminar = ps.executeUpdate();
            if (eliminar == 1) {
                JOptionPane.showMessageDialog(null, "Alumno borrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumnos");
        }

    }

    public Alumno buscarAlumnoPorId(int id) {
        // Recordar que para buscar un "dato" en la BD se hace con un SELECT
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        // NOTA: el ID del alumno es un parámetro dinámico
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet buscarId = ps.executeQuery();
            // Como me devuelve una única fila va...
            if (buscarId.next()) { // "Si en el Result Set hay un elemento, entonces...
                // Voy seteando cada parámetro con los datos del alumno correspondientes al id que se ingresó
                // Pero para esto, primero creo un objeto alumno de tipo Alumno seteado en null (antes del try)
                alumno = new Alumno(); // Creo un nuevo alumno, con el constructor vacío
                // Empiezo a setear:
                alumno.setIdAlumno(id);
                alumno.setDni(buscarId.getInt("dni"));
                alumno.setApeliido(buscarId.getString("apellido"));
                alumno.setNombre(buscarId.getString("nombre"));
                alumno.setFechaNac(buscarId.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            } else { // Si en el Result Set no hay un elemento...
                JOptionPane.showMessageDialog(null, "No existe un alumno con el ID ingresado");
            }
            // RECORDAR CERRAR EL PREPAREDSTATEMENT!!! 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumnos");
        } 

        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        
        String sql = "SELECT isAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
        // Seteo alumno en null, luego le cargo los datos del alumno buscado
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet buscarDni = ps.executeQuery(); // Uso el query que significa "CONSULTA"
            if(buscarDni.next()){ // Si se encuentra un alumno con ese dni, entonces... se crea un nuevo objeto alumno y se guardar ahí los datos del alumno encontrado
                alumno = new Alumno();
                alumno.setIdAlumno(buscarDni.getInt("idAlumno"));
                alumno.setApeliido(buscarDni.getString("apellido"));
                alumno.setNombre(buscarDni.getString("nombre"));
                alumno.setFechaNac(buscarDni.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);               
            } else{
                JOptionPane.showMessageDialog(null, "No existe un alumno con el DNI ingresado");
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumnos");
        }
         return alumno;
    }
    
    
    // El método listar alumnos lista todos los alumnos activos, si quisera listar los alumnos que estan dados de baja
    // podría agregar un método que los liste    
    public List<Alumno> listarAlumnos(){
      String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado = 1";
      // Otra posibilidad es "SELECT * FROM alumno WHERE estado = 1", recordar que el * invoca todos los parámetros
      // Creo una lista de alumnos porque me va a devolver una lista de TODOS los alumnos que se encuentren activos
      ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet listaAlumnos = ps.executeQuery();
            // En este caso, a diferencia de los demás,  la lista me devuelve MÁS DE UNA fila, por eso la recorro con un WHILE y NO con un IF
            while (listaAlumnos.next()) {                
                // Mientras haya elementos en esa fila, le digo que se cree un alumno vacío
                Alumno alumno = new Alumno();
                // Luego a ese alumno, hay que setearle todos los datos
                alumno.setIdAlumno(listaAlumnos.getInt("idalumno"));
                alumno.setDni(listaAlumnos.getInt("dni"));
                alumno.setApeliido(listaAlumnos.getString("apellido"));
                alumno.setNombre(listaAlumnos.getString("nombre"));
                alumno.setFechaNac(listaAlumnos.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                // Finalmente a la lista "alumnos" le agrego (add) ese alumno
                alumnos.add(alumno);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumnos");
        }
     return alumnos;
    }
         
    
}
