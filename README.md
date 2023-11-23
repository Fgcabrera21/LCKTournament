# LCKTournament
Contenido
Introducción al Proyecto de Gestión de Torneo	2
Desarrollo	2
Características Principales	2
Objetivo del Proyecto	2
Contenido del proyecto	2
Funcionamiento General de la Aplicación	3
Clases	3
1. AplicacionTorneo.java	3
Métodos Principales:	3
2. CargadorDeEquipos.java	3
Métodos Principales:	3
3. Equipo.java	3
Métodos Principales:	3
4. Jugador.java	3
Métodos Principales:	3
5. Main.java	4
Métodos Principales:	4
6. Partido.java	4
Métodos Principales:	4
7. Torneo.java	4
Métodos Principales:	4
Conclusión	4

 
Introducción al Proyecto de Gestión de Torneo
Este proyecto de Java está diseñado para administrar y simular un torneo de 10 equipos, proporcionando una solución integral para la gestión de partidos, estadísticas de equipos y jugadores, y la visualización de resultados. La aplicación está construida en Java, un lenguaje de programación ampliamente utilizado, conocido por su robustez y portabilidad.
El torneo se basa en un formato de liga, donde varios equipos compiten entre sí. Cada equipo consta de jugadores individuales, y cada uno de estos jugadores acumula estadísticas personales: kills, deaths y assists. El progreso del torneo, incluyendo los resultados de los partidos y las estadísticas acumuladas, se maneja de manera dinámica y se almacena en un archivo JSON para su persistencia y fácil acceso.
Desarrollo
Características Principales
Gestión de Equipos y Jugadores: La aplicación permite cargar los detalles de los equipos y jugadores desde un archivo JSON, asegurando una configuración inicial rápida y eficiente.
Simulación de Partidos: Los partidos entre equipos se simulan de acuerdo con la lógica definida, incluyendo la generación aleatoria de estadísticas de partidos y la determinación de los ganadores mediante una estadística interna, invisible al usuario.
Actualización Dinámica de Estadísticas: Las estadísticas de los jugadores y equipos se actualizan automáticamente después de cada partido, reflejando el rendimiento actual en el torneo.
Interfaz de Usuario: La interacción con el usuario se maneja a través de un menú de consola claro y sencillo, permitiendo al usuario realizar diversas acciones como visualizar equipos, estadísticas, simular jornadas y reiniciar el torneo.
Persistencia de Datos: Los resultados y estadísticas del torneo se guardan en un archivo JSON, lo que facilita el seguimiento del progreso y proporciona un medio para restaurar el estado del torneo.
Objetivo del Proyecto
El objetivo principal de este proyecto es ofrecer una herramienta eficiente y fácil de usar para la gestión del torneo LCK. Al automatizar la simulación de partidos y el seguimiento de estadísticas, la aplicación permite a los usuarios centrarse en la estrategia y la planificación del torneo, dejando la logística y la administración de datos en manos del software.
Contenido del proyecto
El archivo consta de varias clases que administran los jugadores, los equipos, las partidas y el torneo y un archivo JSON con los detalles de los equipos y los rosters, en el cual se almacenarán las estadísticas cada vez que finalice una fecha del torneo. 
Los detalles de los jugadores del archivo JSON almacenan, tras cada fecha, las estadísticas adquiridas aleatoriamente en cada partida y la suman al total en sus respectivas variables asociadas. Luego, si se invoca al método que reinicia el torneo, todas vuelven a cero almacenándose una instancia completamente limpia de las estadísticas.


Funcionamiento General de la Aplicación
La aplicación permite al usuario gestionar un torneo de equipos, visualizar y actualizar estadísticas, simular partidos y guardar los resultados en un archivo JSON. El usuario interactúa con la aplicación a través de AplicacionTorneo, que ofrece un menú de opciones. Cada opción del menú permite realizar diferentes acciones como ver equipos, estadísticas, simular partidos y actualizar el archivo JSON.
Clases
1. AplicacionTorneo.java
Propósito: Esta clase es la interfaz de usuario de la aplicación. Permite al usuario interactuar con el torneo a través de un menú de consola.
Métodos Principales:
mostrarMenuPrincipal(): Muestra el menú principal y maneja la selección de opciones del usuario.
Métodos como mostrarEquipos(), mostrarEstadisticasEquipos(), visualizarCalendarioPartidos(), etc., proporcionan funcionalidades específicas según la opción elegida en el menú, como mostrar equipos, estadísticas y el calendario de partidos.
2. CargadorDeEquipos.java
Propósito: Se encarga de cargar la información de los equipos desde un archivo JSON.
Métodos Principales:
cargarEquiposDesdeJSON(): Lee un archivo JSON y convierte los datos en objetos Equipo.
3. Equipo.java
Propósito: Representa un equipo en el torneo, conteniendo información como nombre del equipo y estadísticas.
Métodos Principales:
Constructor para inicializar el equipo.
Getters y setters para acceder y modificar las propiedades del equipo.
reiniciarEstadisticas(): Reinicia las estadísticas del equipo a sus valores iniciales.
4. Jugador.java
Propósito: Representa a un jugador dentro de un equipo, con estadísticas individuales.
Métodos Principales:
Constructor, getters y setters.
incrementarTotales(): Incrementa las estadísticas totales del jugador.




5. Main.java
Propósito: Punto de entrada de la aplicación. Crea una instancia de AplicacionTorneo y comienza la interacción del usuario.
Métodos Principales:
main(): Método principal que inicia la aplicación.
Es en esta clase donde se define la ruta de acceso del archivo JSON mediante el string:
String archivoJSON = "C:\\Users\\Usuario\\Desktop\\Java Project\\demo\\src\\main\\java\\com\\example\\Equipos.json";
6. Partido.java
Propósito: Representa un partido en el torneo, conteniendo la lógica para jugar un partido y actualizar estadísticas.
Métodos Principales:
jugarPartido(): Simula el resultado de un partido y actualiza las estadísticas de los jugadores.
7. Torneo.java
Propósito: Gestiona la lógica del torneo, incluyendo el calendario de partidos y la tabla de posiciones.
Métodos Principales:
generarCalendario(): Genera el calendario de partidos del torneo.
simularJornada(): Simula los partidos de una jornada específica y actualiza las estadísticas.
guardarEnJSON(): Guarda el estado actual del torneo en un archivo JSON.
Conclusión
El desarrollo de este proyecto de gestión de torneo representa un avance significativo en la simplificación y automatización de la organización de eventos competitivos. A través de una aplicación Java intuitiva y robusta, hemos conseguido crear una herramienta que no solo gestiona eficientemente los aspectos logísticos de un torneo, sino que también enriquece la experiencia de los organizadores y participantes.
La capacidad de la aplicación para simular partidos, actualizar estadísticas en tiempo real y persistir los datos relevantes en un archivo JSON, asegura que los organizadores puedan mantener un control preciso y detallado sobre el progreso del torneo. Además, las características como la generación aleatoria de estadísticas de partido y la actualización automática de las estadísticas de equipos y jugadores, añaden un nivel de dinamismo y realismo al torneo.
La interfaz de usuario basada en consola es fácil de navegar y permite a los usuarios realizar una variedad de acciones de manera eficiente, lo que hace que la gestión del torneo sea accesible incluso para aquellos con conocimientos técnicos limitados. La integración de la carga y almacenamiento de datos a través del formato JSON facilita la escalabilidad y la adaptabilidad del sistema a diferentes escenarios de torneo.

En conclusión, este proyecto no solo cumple con los requisitos funcionales establecidos, sino que también proporciona una plataforma sólida y flexible para la gestión de torneos. Es un testimonio del poder de la programación orientada a objetos y del uso eficaz de las estructuras de datos y algoritmos para resolver problemas complejos en el mundo real. Con su finalización, se abre la puerta a oportunidades futuras para mejoras y nuevas características, asegurando que la aplicación siga siendo relevante y valiosa para sus usuarios.
