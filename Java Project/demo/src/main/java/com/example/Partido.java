package com.example;

import java.util.Random;

public class Partido {
    private boolean jugado;
    private Equipo equipo1;
    private Equipo equipo2;

    private Equipo ganador;
    // Incluir atributos para las estadísticas del partido

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    // Constructor
    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        this.jugado = false; // Inicialmente, el partido no se ha jugado
        // Inicialización de las estadísticas del partido
    }

    public void jugarPartido() {
        // Lógica para simular el partido y establecer el ganador
        this.ganador = calcularGanador();
        this.jugado = true;

    }

    public String getResultado() {
        if (!jugado) {
            return "Partido aún no jugado";
        }
        return "Ganador: " + ganador.getTeamName();
    }

    public boolean isJugado() {
        return jugado;
    }

    // Método para calcular la puntuación
    public Equipo calcularGanador() {
        int puntuacionEquipo1 = calcularPuntuacion(equipo1);
        int puntuacionEquipo2 = calcularPuntuacion(equipo2);

        if (puntuacionEquipo1 == puntuacionEquipo2) {
            // Elegir ganador aleatoriamente en caso de empate
            Random random = new Random();
            return random.nextBoolean() ? equipo1 : equipo2;
        }
        return puntuacionEquipo1 > puntuacionEquipo2 ? equipo1 : equipo2;
    }

    private int calcularPuntuacion(Equipo equipo) {
        int puntuacion = 0;

        // Sumar puntuación basada en las estadísticas del equipo
        puntuacion += equipo.getTorresDestruidas() * 7;
        puntuacion += equipo.getInhibidoresDestruidos() * 10;
        puntuacion += equipo.getHeraldosAsesinados() * 5;
        puntuacion += equipo.getNashorsAsesinados() * 20;

        // Sumar puntuación basada en las estadísticas de los jugadores
        for (Jugador jugador : equipo.getRoster()) {
            puntuacion += jugador.getKills() * 2; // Kills
            puntuacion -= jugador.getDeaths(); // Deaths
            puntuacion += jugador.getAssists(); // Assists
        }

        return puntuacion;
    }

    // Método para generar estadísticas aleatorias
    public void generarEstadisticasAleatorias() {
        Random random = new Random();

        // Estadísticas para cada equipo
        generarEstadisticasEquipo(equipo1, random);
        generarEstadisticasEquipo(equipo2, random);

        // Asignar heraldos, nashors y dragones
        asignarHeraldosNashorsYDragones(equipo1, equipo2, random);
    }

    private void generarEstadisticasEquipo(Equipo equipo, Random random) {
        equipo.setTorresDestruidas(random.nextInt(7) + 5); // Entre 5 y 11
        equipo.setInhibidoresDestruidos(random.nextInt(3) + 1); // Entre 1 y 3

        // Estadísticas para cada jugador del equipo
        for (Jugador jugador : equipo.getRoster()) {
            int kills = random.nextInt(16); // Entre 0 y 15
            int deaths = random.nextInt(11); // Entre 0 y 10
            int assists = random.nextInt(26); // Entre 0 y 25

            jugador.setKills(kills);
            jugador.setDeaths(deaths);
            jugador.setAssists(assists);

            // Incrementar estadísticas totales
            jugador.incrementarTotales(kills, deaths, assists);
        }
    }

    private void asignarHeraldosNashorsYDragones(Equipo equipo1, Equipo equipo2, Random random) {
        // Asignar heraldos (2 en total)
        int heraldos = 2;
        for (int i = 0; i < heraldos; i++) {
            if (random.nextBoolean()) {
                equipo1.setHeraldosAsesinados(equipo1.getHeraldosAsesinados() + 1);
            } else {
                equipo2.setHeraldosAsesinados(equipo2.getHeraldosAsesinados() + 1);
            }
        }

        // Asignar nashors (hasta 3 en total)
        int nashors = random.nextInt(4); // Entre 0 y 3
        for (int i = 0; i < nashors; i++) {
            if (random.nextBoolean()) {
                equipo1.setNashorsAsesinados(equipo1.getNashorsAsesinados() + 1);
            } else {
                equipo2.setNashorsAsesinados(equipo2.getNashorsAsesinados() + 1);
            }
        }

        // Asignar dragones, 5 al ganador y entre 0 y 3 al perdedor
        Equipo ganador = calcularGanador();
        Equipo perdedor = (ganador == equipo1) ? equipo2 : equipo1;
        ganador.setDragonesAsesinados(5);
        perdedor.setDragonesAsesinados(random.nextInt(4)); // Entre 0 y 3
    }
}
