
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.*;
import universidadejemplo.AccesoADatos.InscripcionData;

import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;

public class UniversidadEjemplo {

    public static void main(String[] args) {
    
        InscripcionData id=new InscripcionData();
        
    //Pruebas en Clases de carpeta AccesoADatos
    /*PRUEBAS InscripcionDAata*/
        
        //id.guardarInscripcion(insc);
        //id.actualizarNota(7, 2, 7);
        //id.borrarInscripcionMateriaAlumno(7, 2);
        //List<Inscripcion> obtenerInscripciones() es lo siguiente:
//            for(Inscripcion inscripcion:id.obtenerInscripciones()){
//                System.out.println("id "+inscripcion.getIdInscripcion());
//                System.out.println("Apellido "+inscripcion.getAlumno().getApellido());
//                System.out.println("Mzteria "+inscripcion.getMateria().getNombre());
//            }
     
        
    }
}

/*Nota: Cuando las sentencia que envío a la base de datos son: Insert. Update, Delete invoco el
método executeUpdate; pero si envío un Select, utilizo executeQuery para obtener el ResultSet.
*/