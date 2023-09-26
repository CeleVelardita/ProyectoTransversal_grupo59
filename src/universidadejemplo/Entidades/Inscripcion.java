
package universidadejemplo.Entidades;

public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;

    
    
    
    
    
    
    /*-------Apartado para AdministracionView_ManipulacionDeNotas---------------*/
    private String nombreMateria; //es para AdministracionView_ManipulacionDeNotas 
    private int id_Materia;
    //Constructor para AdministracionView_ManipulacionDeNotas
    public Inscripcion(int id_Materia, String nombreMateria, double nota) {
        this.id_Materia = id_Materia;
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }
    //Getter y Setter 

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }
    
    public String getNombreMateria() {
        return nombreMateria;
    }
    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    /*-------------------------------------------------------------------------*/
    
    
    
    
    
    
    
    
    //Constructor vacío
    public Inscripcion() {
    }
        
    //Constructor completo
    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    
    //Constructor sin idInscripcion
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    //Getter y Setter 
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String insc= this.idInscripcion+" "+this.alumno.getApellido()+", "+this.alumno.getNombre()+" "+this.materia.getNombre();
        return insc;
    }
}
