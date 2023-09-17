
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL="jbdc:mariadb://localhost:3306/"; 
    private static final String DB="universidadulp";
    private static final String USUARIO="root";
    private static String PASSWORD="";
    
    private static Connection connection;    
    
    // Método constructor
    // HAGO UN CONSTRUCTOR PRIVADO PARA CONTROLAR LA CANTIDAD DE INSTANCIAS DE LA CLASE "CONEXION"
    // Al ser privado, no voy a poder instanciar objetos desde afuera de esta clase
    private Conexion(){}
    // Creo métodos estáticos para poder implemetar métodos de tipo connection, pero primero se debe crear la conexión a la BD 
    public static Connection getConexion(){
        
        if(connection==null){
            try{
                Class.forName("org.mariadb.jdbc.Driver"); // Cargo los Driver
                // Setup the connection with the DB
                // Creo el objeto connection
                
                /*connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                                                        +"&user=" + USUARIO + "&password=" + PASSWORD    
                                                        ); ESTO QUE ESTÁ EN LA GUÍA NO ME PERMITE LA CONEXIÓN A LA BD - CELE*/
                
                connection = DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp","root", "");
                // si se quiere se podría agregar un JOption con un mensaje indicando que se ha conectado a la BD
                JOptionPane.showMessageDialog(null, "Conectado");
            } catch(SQLException ex){
                // RECORDAR!! El primer parámetro es "null" porque no se lanza desde ninguna ventana
                JOptionPane.showMessageDialog(null, "Error al conectarse a la BD "+ex.getMessage());                
            } catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers "+ex.getMessage());                
            }  
        }
    return connection;
    }
}
