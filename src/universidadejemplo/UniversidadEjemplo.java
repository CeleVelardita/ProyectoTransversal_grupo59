
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.*;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.Conexion;
import universidadejemplo.Entidades.Alumno;
/**
 *
 * @author Frank
 */
public class UniversidadEjemplo {
    
    public static void main(String[] args) {        
              
       /*try{
           //cargar driver de conexión
           Class.forName("org.mariadb.jdbc.Driver");
           
           //conexión a la base de datos
           Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp","root", "");
           */
           
           
           
           
           
           // Soy CELE probando/aprendiendo cómo funcionan las cosas para entender mejor... En lugar de cargar
           // los drivers en el main, llamar a la clase conexion donde ya está todo cargado, por ende, otra alternativa
           // para probar que funciona sería...
           
           Connection con = Conexion.getConexion();
           
           // Cargo un alumno           
           Alumno pepito = new Alumno(2, 12312312, "Perez", "Tato", LocalDate.of(1987, 3, 13), true); // Va el constructor sin el ID porque aún no lo tiene, es un nuevo alumno
           AlumnoData alum = new AlumnoData(); // Este objeto me permite agregar un alumno a la tabla
           //alum.guardarAlumno(pepito); // Luego de crear el AlumnoData, le digo que lo guarde
           // Comento la línea anterior porque el alumno ya está cargado en la BD y le agrego el ID al constructor para indicar que ese alumno ya existe
           
           // Modifico un alumno
           //alum.modificarAlumno(pepito);
           
           // Elimino un alumno
           alum.eliminarAlumno(2);
           
          
           
           
           
           
           /*Ingresamos una materia a la tabla materia
           
           String sql= "insert into materia (nombre, año, estado) values ('Laboratorio 2', 2, true)";
           
           PreparedStatement ps=conn.prepareStatement(sql);
           int filas=ps.executeUpdate();
           if(filas>0){
               JOptionPane.showMessageDialog(null, "Materia agregada Exitosamente");
           }*/
           
           
           /*
           //agregamos un alumno
           
           String sql="insert into alumno (dni, apellido, nombre, fechaNacimiento, estado)" 
                      +"values(52745628,'Lopez','Juan', ' " + LocalDate.of(2000,Month.AUGUST,29)+"',true);";
          
           PreparedStatement ps=conn.prepareStatement(sql);
           int filas=ps.executeUpdate();
           if(filas>0){
               JOptionPane.showMessageDialog(null, "Alumno ingresado Exitosamente");
           }*/
           
           
           //Obtener todos los alumnos activos y listarlos por consola
           /*
           String sql="select * from alumno where estado = true";
           PreparedStatement ps=conn.prepareStatement(sql);
           ResultSet resultado=ps.executeQuery();
           
           while(resultado.next()){
               System.out.println("Id "+resultado.getInt("idAlumno"));
               System.out.println("DNI "+resultado.getInt("dni"));
               System.out.println("Apellido "+resultado.getString("apellido"));
               System.out.println("Nombre "+resultado.getString("nombre"));
               System.out.println("Fecha de Nacimiento "+resultado.getDate("fechaNacimiento"));
               System.out.println("-----------------------------------------------------------"); 
           }
           
       } catch (ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Debe agregar los driver al proyecto!!!");           
       } /*catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Error de Conexión");
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
       }
       */
      
    } 

}

/*Nota: Cuando las sentencia que envío a la base de datos son: Insert. Update, Delete invoco el
método executeUpdate; pero si envío un Select, utilizo executeQuery para obtener el ResultSet.
*/
