package com.example;

import java.util.List;
import java.util.Scanner;

public class AplicacionTorneo {
    private Torneo torneo;

    public AplicacionTorneo(String archivoJSON) {
        List<Equipo> equipos = CargadorDeEquipos.cargarEquiposDesdeJSON(archivoJSON);
        this.torneo = new Torneo(equipos);
        torneo.generarCalendario(); // Generar el calendario al inicio
    }

    public void mostrarMenuPrincipal(String archivoJSON) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú Principal del Torneo");
            System.out.println("1. Mostrar Equipos");
            System.out.println("2. Mostrar Estadísticas de Equipos");
            System.out.println("3. Mostrar Estadísticas de Jugadores");
            System.out.println("4. Visualizar Calendario de Partidos");
            System.out.println("5. Mostrar Tabla de Posiciones");
            System.out.println("6. Simular Siguiente Jornada");
            System.out.println("7. Reiniciar Torneo");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarEquipos();
                    break;
                case 2:
                    mostrarEstadisticasEquipos();
                    break;
                case 3:
                    mostrarEstadisticasJugadores();
                    break;
                case 4:
                    visualizarCalendarioPartidos();
                    break;
                case 5:
                    torneo.mostrarTablaPosiciones();
                    break;
                case 6:
                    torneo.simularJornada(archivoJSON);
                    break;
                case 7:
                    torneo.reiniciarTorneo(archivoJSON);
                    break;
                case 0:
                    System.out.println("Saliendo del Torneo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarEquipos() {
        System.out.println("Equipos Participantes:");
        for (Equipo equipo : torneo.getEquipos()) {
            System.out.println(equipo.getTeamName());
        }
    }

    private void mostrarEstadisticasEquipos() {
        System.out.println("Estadísticas de Equipos:");
        for (Equipo equipo : torneo.getEquipos()) {
            System.out.println("Equipo: " + equipo.getTeamName());
            System.out.println("Victorias: " + equipo.getVictories());
            System.out.println("Derrotas: " + equipo.getDefeats());
            System.out.println("Torres destruidas: " + equipo.getTorresDestruidas());
            System.out.println("Inhibidores destruidos: " + equipo.getInhibidoresDestruidos());
            System.out.println("Dragones asesinados: " + equipo.getDragonesAsesinados());
            System.out.println("Heraldos asesinados: " + equipo.getHeraldosAsesinados());
            System.out.println("Nashors asesinados: " + equipo.getNashorsAsesinados());

            System.out.println();
        }
    }

    private void mostrarEstadisticasJugadores() {
        System.out.println("Estadísticas de Jugadores:");
        for (Equipo equipo : torneo.getEquipos()) {
            System.out.println("Equipo: " + equipo.getTeamName());
            for (Jugador jugador : equipo.getRoster()) {
                System.out.println("Jugador: " + jugador.getPlayerName());
                // Mostrar estadísticas del jugador
            }
            System.out.println();
        }
        visualizarEstadisticasJugadorEspecifico();
    }

    private void visualizarCalendarioPartidos() {
        System.out.println("Calendario de Partidos:");
        int jornadaNum = 1;
        for (List<Partido> jornada : torneo.getCalendario()) {
            System.out.println("Jornada " + jornadaNum + ":");
            for (Partido partido : jornada) {
                String resultado = partido.isJugado() ? "Resultado: " + partido.getResultado() : "Pendiente";
                System.out.println(partido.getEquipo1().getTeamName() + " vs " + partido.getEquipo2().getTeamName()
                        + " - " + resultado);
            }
            jornadaNum++;
            System.out.println();
        }
    }

    private void visualizarEstadisticasJugadorEspecifico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un equipo:");
        int indice = 1;
        for (Equipo equipo : torneo.getEquipos()) {
            System.out.println(indice++ + ". " + equipo.getTeamName());
        }
        int eleccionEquipo = scanner.nextInt();
        Equipo equipoSeleccionado = torneo.getEquipos().get(eleccionEquipo - 1);

        System.out.println("Seleccione un jugador:");
        indice = 1;
        for (Jugador jugador : equipoSeleccionado.getRoster()) {
            System.out.println(indice++ + ". " + jugador.getPlayerName());
        }
        int eleccionJugador = scanner.nextInt();
        Jugador jugadorSeleccionado = equipoSeleccionado.getRoster().get(eleccionJugador - 1);

        // Mostrar estadísticas del jugador seleccionado
        System.out.println("Estadísticas de " + jugadorSeleccionado.getPlayerName() + ":");
        System.out.println("Kills: " + jugadorSeleccionado.getKills());
        System.out.println("Deaths: " + jugadorSeleccionado.getDeaths());
        System.out.println("Assists: " + jugadorSeleccionado.getAssists());
        // Puedes añadir aquí más estadísticas si es necesario
        System.out.println("Total de Kills: " + jugadorSeleccionado.getTotalKills());
        System.out.println("Total de Deaths: " + jugadorSeleccionado.getTotalDeaths());
        System.out.println("Total de Assists: " + jugadorSeleccionado.getTotalAssists());
    }
}
