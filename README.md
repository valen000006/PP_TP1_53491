Sistema de Gestión de Eventos Universitarios
Aplicación en Java desarrollada con Programación Orientada a Objetos para administrar eventos, sus salas, actividades (charlas, talleres y cursos) e inscripciones de estudiantes.

¿Qué hace este programa?
Gestiona eventos: Permite crear eventos universitarios, asignarles un costo y evaluar si son gratuitos.

Usa salas: Asocia un aula o sala física a cada evento controlando la capacidad.

Crea actividades: Añade charlas, talleres o cursos propios de cada evento controlando un cupo máximo.

Inscribe estudiantes: Anota alumnos a las actividades y permite listar quiénes están inscriptos.

Maneja excepciones de cupo: Lanza y captura una excepción personalizada (CupoExcedidoException) cuando se intenta superar el cupo disponible.

Emite certificados: Genera automáticamente certificados para las actividades que implementan la interfaz Certificable (talleres y cursos).

Filtra y calcula costos: Aplica generics y wildcards para filtrar actividades por tipo y calcular dinámicamente los costos de materiales.

Persiste datos: Guarda y recupera eventos completos en disco mediante la serialización nativa de Java (java.io.Serializable).

Controla copias y contadores: Incluye constructores de copia y un contador total de eventos creados.

Estructura de Clases e Interfases
EventoUniversitario: Clase principal que administra los datos del evento, la asignación de sala, su lista de actividades, la persistencia en disco y el conteo global de eventos.

Actividad: Clase abstracta base. Define ID, título, cupo máximo y métodos abstractos para la gestión de inscripciones.

Charla: Clase derivada de Actividad. Incorpora información sobre el disertante.

Taller: Clase derivada de Actividad. Incorpora control de requerimiento de notebook e implementa Certificable.

Curso: Clase derivada de Actividad. Incorpora el nivel del curso e implementa Certificable.

Certificable: Interfaz que define el contrato para la generación de certificados de acreditación.

Estudiante: Almacena el legajo y nombre del alumno.

Inscripcion: Registra la relación entre un estudiante y una actividad determinada.

Sala: Define la capacidad y el nombre del aula asignada.

CupoExcedidoException: Excepción personalizada que se dispara al intentar inscribir estudiantes sobrepasando el límite permitido.

Cómo ejecutar el programa
Abrir el proyecto en IntelliJ IDEA (o cualquier IDE Java compatible con JDK 17+).

Verificar que las clases del paquete modelo implementen Serializable.

Buscar y ejecutar la clase Main para correr el flujo de pruebas, persisencia y resumen de salidas en consola.
