import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Se creen uno o más eventos universitarios.
        EventoUniversitario evento1 = new EventoUniversitario("E01", "Charla Inteligencia Artificial", 0.0, true);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Taller de programación", 2000.0, false);
        //Se cree una copia de cada evento creado utilizando el constructor de copia.
        EventoUniversitario copiaevento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaevento2 = new EventoUniversitario(evento2);
        //Se muestren los datos de los eventos creados y su copia.
        System.out.println("EVENTO: Charla Inteligencia Artificial");
        evento1.mostrarDatos();

        System.out.println("\nEVENTO COPIA: Charla Inteligencia Artificial");
        copiaevento1.mostrarDatos();

        System.out.println("\nEVENTO: Taller de programación");
        evento2.mostrarDatos();

        System.out.println("\nEVENTO COPIA: Taller de programación");
        copiaevento2.mostrarDatos();
        //Se muestre el contador de eventos con la totalidad de eventos creados.
        System.out.println("\nTotal de eventos creados:" + EventoUniversitario.getcantidadEventos());

        //Se construya una lista de estudiantes.


        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana Morales", "53493"));
        estudiantes.add(new Estudiante("Gabriel Fernández", "52481"));
        estudiantes.add(new Estudiante("Victoria Martínez", "51390"));

        //Se asigne una sala a cada evento.
        Sala salaA = new Sala(5, "Aula A");
        Sala salaB = new Sala(8, "Aula B");

        evento1.asignarSala(salaA);
        evento2.asignarSala(salaB);

        //Se creen actividades propias de cada evento.
        evento1.crearActividad(1, "Aplicaciones de la IA Generativa", 40, "Charla", "Dra. Martínez", false);
        evento2.crearActividad(2, "Taller de Python", 20, "Taller", "", true);
        evento2.crearActividad(3, "Taller de Java", 35, "Taller", "", false);

        //Se inscriban estudiantes en cada actividad
        evento1.getActividades().get(0).inscribir(estudiantes.get(0));
        evento1.getActividades().get(0).inscribir(estudiantes.get(1));
        evento2.getActividades().get(0).inscribir(estudiantes.get(1));
        evento2.getActividades().get(1).inscribir(estudiantes.get(0));
        //Se muestre el resumen de datos por cada evento creado.

        System.out.println("Resumen de datos de cada evento universitario");
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

        System.out.println("Total de eventos creados:" + EventoUniversitario.getcantidadEventos());
    }
}
