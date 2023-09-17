
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?"
                + "WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            // Por último se setea el ID
            ps.setInt(5, alumno.getIdAlumno());
            
            //Luego ejecuto, RECORDAR QUE EL MÉTODO executeUpdate DEVUELVE UN ENTERO CON LA CANTIDAD DE FILAS ACEPTADAS
            int modificacion = ps.executeUpdate();
            
            // Creo un diálogo para que me muestre si se modificó correctamente
            if (modificacion == 1){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }        
    }
    
    // El método eliminarAlumno genera el borrado a través de un operador lógico, se le modifica el estado
    // A diferencia de los otros dos métodos, recibe un entero, puede ser el dni o el id del alumno que deseo eliminar
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        try {
            // UPDATE nombre_tabla SET atributo = lo que quiero poner WHERE clave_foránea
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Acá le digo que quiero que reemplace al id por ese id que le indiqué
            int eliminar = ps.executeUpdate();
            if(eliminar == 1){
                JOptionPane.showMessageDialog(null, "Alumno borrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumnos");
        }
        
    }
    
    
    
    
    
    
}
