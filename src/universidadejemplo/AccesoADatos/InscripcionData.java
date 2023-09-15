/*
Esta clase además de poseer los métodos que permitirán hacer un CRUD sobre la tabla Inscripcion,
tiene métodos que permiten hacer operaciones un poco más complejas como el método
“obtenerMateriasCursadas”, que recibiendo el id del alumno, nos retornará las materias en las que
este está inscripto.

CRUD = Create, Read, Update, Delete (Crear, Leer, Actualizar, Eliminar)
*/
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Inscripcion;

public class InscripcionData {
    private Connection con=null;
    
    public InscripcionData(){
        this.con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql="INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES(?,?,?)"; //3 valores que se llenan dinámicamente, entonces ponemos (?,?,?) como valores aquí
        try {
            //creo el acceso a la tabla con su respectivo catch porque puede saltar una Exception
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); // Statement.RETURN_GENERATED_KEYS es una constante que necesitamos porque esperamos una clave
            //si no salta la exception es porque logró acceder a la tabla y puedo continuar
            //ahora mandaré las incripciones con un set
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            //voy a recibir claves que me confiermen que se pudo SETear y las guardo en un tipo result
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción REgistrada");
            }
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción");
        }
    
    }
    
}
