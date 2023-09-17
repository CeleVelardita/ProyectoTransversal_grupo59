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
            ps.close();        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción");
        } 
        
      /*
      Para probar este método   guardarInscripcion(Inscripcion insc)
      tenemos que colocar en el main del proyecto la sentencia:
      guardarInscripcion(insc);
      donde insc será de tipo de la clase Inscripcion por lo que contendrá
      los atributos y forma de tal clase (de la carpeta entidades, modelo de la BD)
      */
    }
        
    //List<Inscripcion> obtenerInscripciones()
    //List<Inscripcion> obtenerInscripcionesPorAlumno(int id)
    //List<Materia> obtenerMateriasCursadas(int id)
    //List<Materia> obtenerMateriasNOCursadas(int id)
     
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMAteria){
        //borrado físico
        String sql= "DELETE FROM inscripcion WHERE idAlumno =? and idMAteria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idAlumno);
            
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
            JOptionPane.showMessageDialog(null, ""+ex.getMessage());
        }
        
    }
    
    public void actualizarNota (int idAlumno, int idMateria, double nota){
     
        String sql="UPDATE inscripcion SET nota = ? where idAlumno = ? and idMateria = ?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble( 1, nota);
            ps.setInt( 1, idAlumno);
            ps.setInt( 3, idAlumno);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción"+ex.getMessage());
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
    
    //List<Alumno> obtenerAlumnosXMateria(int idMateria)
    
}
