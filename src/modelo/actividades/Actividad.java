package modelo.actividades;

import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

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

    public Inscripcion inscribir (Estudiante estudiante) throws CupoExcedidoException{
        if (inscripciones.size() >= cupoMaximo) {
           throw new CupoExcedidoException("No se puede inscribir al estudiante " + estudiante.getNombre() + ". Cupo máximo alcanzado.");
        }
        Inscripcion nuevaInscripcion = new Inscripcion (estudiante);
        this.inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void mostrarInscripciones (){
        System.out.println("Estudiantes inscriptos");
        for (Inscripcion i: inscripciones){
            System.out.println(i.getEstudiante().getNombre());

        }

    }

    public final void mostrarIdentificacion(){
        System.out.println("modelo.actividades.Actividad [" + getTipo() + "]: " + titulo + " | Cupo Máximo: " + cupoMaximo);

    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

}
