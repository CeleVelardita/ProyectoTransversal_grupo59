
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Materia;

public class MateriaData {
    
    // Al igual que en AlumnoData, creo un atributo connection para hacer conexión con la BD y usarlo en todos los métodos
    private Connection con = null;
    
    // Se crea el constructor de MateriaData donde se va a inicializar connection
    public MateriaData(){
    con = Conexion.getConexion();
    }
    
    
    // El método guardarMateria hace un INSERT en la tabla materia
    public void guardarMateria(Materia materia) {
        // Preparo la sentencia que voy a enviar
        String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
        try {
            // Creo el objeto ps de tipo PreparedStatement que es el encargado de enviar esa sentencia a la BD
            // Statement.RETURN_GENERATED_KEYS -> Devuelve la lista de claves generadas
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Seteo los tipos de datos que quiero enviar
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());

            // Ahora se ejecutan las sentencias
            ps.executeUpdate();

            // Luego se pide la clave/código generado para cada materia
            ResultSet claveMateria = ps.getGeneratedKeys();

            // Planteo si puede pasar al siguiente renglón, si lo hace, significa que se agregó la materia correctamente
            if (claveMateria.next()) {
               materia.setIdMateria(claveMateria.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia"+ex.getMessage());
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar la materia"+ex.getMessage());
        }
    }

    
    /*
    public Materia buscarMateria(int id){
    //return materia;
    }
    
    public void modificarMateria(Materia materia){
        
    }
    
    public void eliminarMateria (int id){
        
    }
    
    public List<Materia> listarMateria(){
        
    }
    */
    
    
    
}
