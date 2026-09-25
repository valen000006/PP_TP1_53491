import excepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.Sala;
import modelo.actividades.Actividad;
import modelo.actividades.Charla;
import modelo.actividades.Taller;
import modelo.actividades.Curso;
import modelo.certificacion.Certificable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Se creen uno o más eventos universitarios.
        EventoUniversitario evento1 = new EventoUniversitario("E01", "Charla Inteligencia Artificial", 0.0, true);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Taller de programación", 2000.0, false);

        // Se cree una copia de cada evento creado utilizando el constructor de copia.
        EventoUniversitario copiaevento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaevento2 = new EventoUniversitario(evento2);

        // Se muestren los datos de los eventos creados y su copia.
        System.out.println("EVENTO: Charla Inteligencia Artificial");
        evento1.mostrarDatos();

        System.out.println("\nEVENTO COPIA: Charla Inteligencia Artificial");
        copiaevento1.mostrarDatos();

        System.out.println("\nEVENTO: Taller de programación");
        evento2.mostrarDatos();

        System.out.println("\nEVENTO COPIA: Taller de programación");
        copiaevento2.mostrarDatos();

        // Se construya una lista de estudiantes.
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana Morales", "53493"));
        estudiantes.add(new Estudiante("Gabriel Fernández", "52481"));
        estudiantes.add(new Estudiante("Victoria Martínez", "51390"));
        estudiantes.add(new Estudiante("Lucas Benítez", "54120"));
        estudiantes.add(new Estudiante("Sofía Rossi", "55231"));
        estudiantes.add(new Estudiante("Mateo Gómez", "56342"));

        // Se asigne una sala a cada evento.
        Sala salaA = new Sala(5, "Aula A");
        Sala salaB = new Sala(8, "Aula B");

        evento1.asignarSala(salaA);
        evento2.asignarSala(salaB);

        // Se creen actividades propias de cada evento (parámetros originales conservados)
        evento1.crearActividad(1, "Aplicaciones de la IA Generativa", 40, "Charla", "Dra. Martínez", false);
        evento2.crearActividad(2, "Taller de Python", 5, "Taller", "", true);
        evento2.crearActividad(4, "Curso de Inteligencia Artificial", 30, "Curso", "", false);
        evento2.crearActividad(5, "Curso de Programación Java", 25, "Curso", "", false);

        try {
            System.out.println("\n Inscripción de estudiantes en actividades");
            evento1.getActividades().get(0).inscribir(estudiantes.get(1));
            evento1.getActividades().get(0).inscribir(estudiantes.get(2));

            // --- Inscripciones en Evento 2: Actividad 0
            evento2.getActividades().get(0).inscribir(estudiantes.get(1));
            evento2.getActividades().get(0).inscribir(estudiantes.get(2));
            evento2.getActividades().get(0).inscribir(estudiantes.get(3));
            evento2.getActividades().get(0).inscribir(estudiantes.get(4));
            evento2.getActividades().get(0).inscribir(estudiantes.get(5));

            // --- Inscripciones en Evento 2: Actividad 1
            evento2.getActividades().get(1).inscribir(estudiantes.get(0));
            evento2.getActividades().get(1).inscribir(estudiantes.get(1));
            evento2.getActividades().get(1).inscribir(estudiantes.get(2));

            // --- Inscripciones en Evento 2: Actividad 2
            evento2.getActividades().get(2).inscribir(estudiantes.get(3));
            evento2.getActividades().get(2).inscribir(estudiantes.get(4));

            System.out.println("Intentando inscribir a un estudiante extra sobrepasando el cupo del Taller...");

            evento2.getActividades().get(0).inscribir(estudiantes.get(0));

        } catch (CupoExcedidoException e) {
            System.err.println("Error al inscribir " + e.getMessage());
        }

        List<EventoUniversitario> eventos = List.of(evento1, evento2);

        // Persistencia del evento (Ejercicio 3)
        for (EventoUniversitario evento : eventos) {
            try {
                evento.persistirEvento();
                EventoUniversitario recuperado = evento.recuperarEvento(evento.getId());
                System.out.println("\nEvento recuperado exitosamente: " + recuperado.getTitulo());
                evento.mostrarDatos();

            } catch (FileNotFoundException e) {
                System.err.println(" Archivo no encontrado: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("No fue posible reconstruir el objeto almacenado: " + e.getMessage());
            } catch (IOException e) {
                System.err.println(" Se produjo un error de entrada/salida: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
            } finally {
                System.out.println("Proceso de persistencia finalizado para " + evento.getTitulo() + ".");
            }
        }

        // f y g. Emisión y muestreo de Certificados
        System.out.println("\nEMISIÓN DE CERTIFICADOS");

        for (EventoUniversitario evento : eventos) {
            for (Actividad actividad : evento.getActividades()) {
                // f. Filtra solo las actividades certificables
                if (actividad instanceof Certificable certificable) {
                    System.out.println("CERTIFICADOS EMITIDOS PARA LA ACTIVIDAD: " + actividad.getTitulo());

                    // g. Muestra los certificados generados
                    for (Inscripcion inscripcion : actividad.getInscripciones()) {
                        String certificado = certificable.generarCertificado(inscripcion.getEstudiante());
                        System.out.println(" -> " + certificado);
                    }
                }
            }
        }

        // Filtrado genérico y costos de materiales
        System.out.println("\nFILTRADO GENÉRICO Y COSTO DE MATERIALES");
        for (EventoUniversitario evento : eventos) {
            System.out.println("\nEVENTO: " + evento.getTitulo());

            List<Charla> charlas = evento.filtrarActividadesPorTipo(Charla.class);
            List<Taller> talleres = evento.filtrarActividadesPorTipo(Taller.class);
            List<Curso> cursos   = evento.filtrarActividadesPorTipo(Curso.class);

            System.out.println("Cantidad de Charlas: " + charlas.size());
            System.out.println("Cantidad de Talleres: " + talleres.size());
            System.out.println("Cantidad de Cursos: " + cursos.size());

            // f. Se calcula y muestra el costo de materiales con Wildcards
            double costoCharlas  = evento.calcularCostoMateriales(charlas);
            double costoTalleres = evento.calcularCostoMateriales(talleres);
            double costoCursos   = evento.calcularCostoMateriales(cursos);
            double costoTotal    = evento.calcularCostoMateriales(evento.getActividades());

            System.out.println("\n Costo de Materiales:");
            System.out.println("Costo Materiales Charlas: $" + costoCharlas);
            System.out.println("Costo Materiales Talleres: $" + costoTalleres);
            System.out.println("Costo Materiales Cursos: $" + costoCursos);
            System.out.println("Costo Materiales Total Evento: $" + costoTotal);
        }

        // Resumen final de datos de cada evento universitario
        System.out.println("\nRESUMEN DE DATOS DE CADA EVENTO UNIVERSITARIO");

        System.out.println("\nEvento 1:");
        evento1.mostrarDatos();
        System.out.println("Actividades del evento 1:");
        for (Actividad act : evento1.getActividades()) {
            act.mostrarIdentificacion();
            act.mostrarInscripciones();
        }

        System.out.println("\nEvento 2:");
        evento2.mostrarDatos();
        System.out.println("Actividades del evento 2:");
        for (Actividad act : evento2.getActividades()) {
            act.mostrarIdentificacion();
            act.mostrarInscripciones();
        }

        System.out.println("\nTOTAL DE EVENTOS CREADOS: " + EventoUniversitario.getcantidadEventos());
    }
}