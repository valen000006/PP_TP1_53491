import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;

    private List<Actividad> actividades = new ArrayList<>();
    private int Id;
    private int cupo;
    private Sala sala;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public static void setcantidadEventos(int cantidadEventos) {
        EventoUniversitario.cantidadEventos = cantidadEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public double calcularCostoEstimado(){
        if (this.gratuito){
            return 0.0;
        }
        double costoTotal=costoBase;
        for (Actividad actividad: actividades){
            costoTotal += actividad.calcularCostoMateriales();
        }
        return (costoBase + costoTotal)*1.21;

    }

    public void  Actividad(int Id, String titulo, int cupo){
        this.Id = Id;
        this.titulo = titulo;
        this.cupo = cupo;
    }
    public static int getcantidadEventos() {
        return cantidadEventos;
    }

    public EventoUniversitario(EventoUniversitario otro){
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }
    public void asignarSala(Sala sala){

        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupoMaximo, String tipo, String disertante, boolean requiereNotebook) {
        if (tipo.equals("Charla")){
            this.actividades.add(new Charla(id, titulo, cupoMaximo, disertante));
        }
        else if(tipo.equals("Taller")){
            this.actividades.add(new Taller(id, titulo, cupoMaximo, requiereNotebook));
        }

    }
    public void mostrarDatos(){
        System.out.println("Evento " + id + " " + titulo);
        System.out.println("Costo estimado " + calcularCostoEstimado());
        System.out.println("Gratuito " + gratuito);
    }

}

