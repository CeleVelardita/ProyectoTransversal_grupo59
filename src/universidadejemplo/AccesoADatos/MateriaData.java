
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

    public Materia buscarMateria(int id) {
        String sql = "SELECT idMateria, nombre, año, estado FROM materia WHERE idMateria = ?";
        Materia materia = null; // Lo seteo a null para que "arranque de cero"
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet buscarId = ps.executeQuery();
            // Como lo que devuelve es una única fila va in if, en caso de ser una lista, va a un while
            if(buscarId.next()){
                materia = new Materia();
                // Luego de crear una nueva materia en la línea anterior, empiezo a setear
                materia.setIdMateria(buscarId.getInt("idMateria"));
                materia.setNombre(buscarId.getString("nombre"));
                materia.setAnioMateria(buscarId.getInt("año"));
                materia.setActivo(buscarId.getBoolean("estado"));
            } else{ // Si en el ResultSet no encuentra un elemento...
                JOptionPane.showMessageDialog(null, "No se ha encontrado la materia ingresada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla materia");
        }
        return materia;
    }    
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre = ?, año = ?, estado = ? WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            
            // Por último se setea el idMateria
            ps.setInt(4, materia.getIdMateria());
            
            // Luego ejecuto
            int modificacion = ps.executeUpdate();
            
            if(modificacion == 1){
                JOptionPane.showMessageDialog(null, "Materia modificada");
            } else{
                JOptionPane.showMessageDialog(null, "No existe una materia con el código ingresado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la materia "+ex.getMessage());
        }        
    }
    
    public void eliminarMateria (int id){
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Acá le digo que quiero que reemplace al id por el id que le indiqué
            int eliminar = ps.executeUpdate();
            if(eliminar == 1){ // Si encuentra una materia con ese código, la elimina
                JOptionPane.showMessageDialog(null, "Materia eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia");
        }        
    }
    
    public List<Materia> listarMateria() {
        String sql = "SELECT * FROM materia WHERE estado = 1";
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet mat = ps.executeQuery();
            // Recordar que en este caso el resultSet me devuelve más de una fila
            while (mat.next()) { // Mientras haya elementos en esa fila...
                Materia materia = new Materia();
                // Una vez que creo el nuevo objeto materia, le seteo todos los parámetros que se ingresaron
                materia.setIdMateria(mat.getInt("idMateria"));
                materia.setNombre(mat.getString("nombre"));
                materia.setAnioMateria(mat.getInt("año"));
                materia.setActivo(mat.getBoolean("estado"));
                // Por último agrego la materia con todos sus atributos a la lista
                listaMaterias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla materia");
        }        
        return listaMaterias;
    }
    
   
}
