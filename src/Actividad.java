import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    protected int id;
    protected String titulo;
    protected int cupoMaximo;
    public static final int CUPO_MIN = 1;

    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad (int id, String titulo, int cupoMaximo){
        this.id = id;
        this.titulo=titulo;
        this.cupoMaximo=cupoMaximo;
    }

    public Inscripcion inscribir (Estudiante estudiante){
        Inscripcion nuevaInscripcion = new Inscripcion (estudiante);
        this.inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }

    public void mostrarInscripciones (){
        System.out.println("Estudiantes inscriptos");
        for (Inscripcion i: inscripciones){
            System.out.println(i.getEstudiante().getNombre());

        }

    }

    public final void mostrarIdentificacion(){
        System.out.println("Actividad [" + getTipo() + "]: " + titulo + " | Cupo Máximo: " + cupoMaximo);

    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

}
