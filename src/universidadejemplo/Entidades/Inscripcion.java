
package universidadejemplo.Entidades;

public class Inscripcion {
   
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    
    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota){
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        alumno = new Alumno();
        materia = new Materia();
    }
    
    public Inscripcion(Alumno alumno, Materia materia, double nota){
        this.nota = nota;
        alumno = new Alumno();
        materia = new Materia();
    }
    
    public Inscripcion(){
        
    }
    
    
    
    
}
