package modelo.actividades;

import modelo.Estudiante;
import modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller (int id, String titulo, int cupoMaximo, boolean requiereNotebook){
        super (id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        return requiereNotebook ? 5000.0 : 2000.0;
    }

    @Override
    public String getTipo() {
        return "modelo.actividades.Taller";
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado emitido por " + ENTIDAD_EMISORA
                + ": se deja constancia de que " + estudiante.getNombre()
                + " participó en el taller \"" + getTitulo() + "\".";
    }
}
