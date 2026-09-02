Sistema de Gestión de Eventos Universitarios 

Aplicación en Java desarrollada con Programación Orientada a Objetos para administrar eventos, sus salas, actividades (charlas y talleres) e inscripciones de estudiantes.

¿Qué hace este programa?
- Gestiona eventos: Permite crear eventos universitarios, asignarles un costo y ver si son gratuitos.
- Usa salas: Asocia un aula o sala física a cada evento.
- Crea actividades: Añade charlas o talleres propios de cada evento controlando un cupo máximo.
- Inscribe estudiantes: Anota alumnos a las actividades y permite listar quiénes están inscriptos.
- Controla copias y contadores: Incluye constructores de copia y un contador total de eventos creados.

Clases
- EventoUniversitario: Controla los datos del evento, su sala, sus actividades y cuántos eventos se han creado en total.
- Actividad: Base para las actividades. Define el ID, título, cupo máximo y métodos abstractos.
- Charla y Taller: Clases hijas que heredan de Actividad.
- Estudiante: Almacena el nombre y el legajo del alumno.
- Inscripcion: Registra la relación entre el estudiante y la actividad.
- Sala: Define el número y nombre del aula.

Cómo ejecutar el programa
1. Abrir el proyecto en IntelliJ IDEA.
2. Buscar y ejecutar la clase Main para ver las pruebas y el resumen en consola.







