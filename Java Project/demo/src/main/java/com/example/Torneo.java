package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

public class Torneo {
    private List<Equipo> equipos;
    private List<List<Partido>> calendario;
    private int jornadaActual;
    private Equipo equipo1;
    private Equipo equipo2;

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<List<Partido>> getCalendario() {
        return calendario;
    }

    public void setCalendario(List<List<Partido>> calendario) {
        this.calendario = calendario;
    }

    public int getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(int jornadaActual) {
        this.jornadaActual = jornadaActual;
    }

    public Torneo(List<Equipo> equipos) {
        this.equipos = equipos;
        this.calendario = new ArrayList<>();
        this.jornadaActual = 0;
        generarCalendario();
    }

    public void generarCalendario() {
        Collections.shuffle(equipos); // Mezclar los equipos para aleatorizar el calendario

        // Generar partidos para cada jornada
        for (int i = 0; i < equipos.size() - 1; i++) {
            List<Partido> jornada = new ArrayList<>();
            for (int j = 0; j < equipos.size() / 2; j++) {
                // Crear un partido entre equipo[j] y equipo[j + equipos.size() / 2]
                jornada.add(new Partido(equipos.get(j), equipos.get(j + equipos.size() / 2)));
            }
            calendario.add(jornada);
            // Rotar los equipos para la siguiente jornada, excepto el primer equipo
            Collections.rotate(equipos.subList(1, equipos.size()), 1);
        }
    }

    public void actualizarEstadisticasJugadores(Equipo equipo) {
        for (Jugador jugador : equipo1.getRoster()) {
            // Aquí debes reemplazar con la lógica real para obtener las estadísticas del
            // partido
            int killsDelPartido = 0; // Obtener el número real de kills para el jugador en este partido
            int deathsDelPartido = 0; // Obtener el número real de deaths para el jugador en este partido
            int assistsDelPartido = 0; // Obtener el número real de assists para el jugador en este partido

            jugador.incrementarTotales(killsDelPartido, deathsDelPartido, assistsDelPartido);
        }
        for (Jugador jugador : equipo2.getRoster()) {
            // Aquí debes reemplazar con la lógica real para obtener las estadísticas del
            // partido
            int killsDelPartido = 0; // Obtener el número real de kills para el jugador en este partido
            int deathsDelPartido = 0; // Obtener el número real de deaths para el jugador en este partido
            int assistsDelPartido = 0; // Obtener el número real de assists para el jugador en este partido

            jugador.incrementarTotales(killsDelPartido, deathsDelPartido, assistsDelPartido);
        }
    }

    public void simularJornada(String archivoJSON) {
        if (jornadaActual >= calendario.size()) {
            System.out.println("El torneo ya ha concluido.");
            return;
        }
        guardarEnJSON(archivoJSON);
        List<Partido> partidosJornada = calendario.get(jornadaActual);
        for (Partido partido : partidosJornada) {
            partido.generarEstadisticasAleatorias();
            Equipo ganador = partido.calcularGanador();
            actualizarEstadisticasPartido(partido, ganador, archivoJSON);

            // Aquí se actualizaría el archivo JSON

        }

        jornadaActual++;
        guardarEnJSON(archivoJSON);
    }

    private void actualizarEstadisticasPartido(Partido partido, Equipo ganador, String archivoJSON) {
        // Actualizar estadísticas del ganador y del perdedor
        Equipo perdedor = (ganador == partido.getEquipo1()) ? partido.getEquipo2() : partido.getEquipo1();
        ganador.setVictories(ganador.getVictories() + 1);
        perdedor.setDefeats(perdedor.getDefeats() + 1);

        // Actualizar estadísticas adicionales de jugadores y equipos
        guardarEnJSON(archivoJSON);
    }

    public void mostrarTablaPosiciones() {
        // Ordenar equipos por victorias
        equipos.sort(Comparator.comparingInt(Equipo::getVictories).reversed());
        System.out.println("Tabla de Posiciones:");
        System.out.println("Equipo\t\tVictorias\tDerrotas");
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getTeamName() + "\t\t" + equipo.getVictories() + "\t\t" + equipo.getDefeats());
        }
    }

    public void manejarEmpates() {
        // Identificar si hay empates en la primera posición
        List<Equipo> equiposEmpatados = new ArrayList<>();
        int maxVictorias = equipos.get(0).getVictories();
        for (Equipo equipo : equipos) {
            if (equipo.getVictories() == maxVictorias) {
                equiposEmpatados.add(equipo);
            } else {
                break;
            }
        }

        // Si hay más de un equipo empatado en la primera posición, realizar desempate
        if (equiposEmpatados.size() > 1) {
            System.out.println("Hay un empate. Se jugará un mejor de 5 para desempatar.");
            // Lógica para jugar un mejor de 5 y determinar el ganador
        }
    }

    public void reiniciarTorneo(String archivoJSON) {
        // Reiniciar estadísticas de equipos y jugadores
        for (Equipo equipo : getEquipos()) {
            equipo.reiniciarEstadisticas();
            for (Jugador jugador : equipo.getRoster()) {
                jugador.reiniciarEstadisticas();
            }
        }

        // Generar un nuevo calendario
        // torneo.generarCalendario();
        guardarEnJSON(archivoJSON);
        System.out.println("Torneo reiniciado.");
    }

    public void guardarEnJSON(String archivoJSON) {
        try (FileWriter writer = new FileWriter(archivoJSON)) {
            new Gson().toJson(this.equipos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
