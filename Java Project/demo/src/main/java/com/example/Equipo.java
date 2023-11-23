package com.example;

import java.util.List;

public class Equipo {
    private String teamName;
    private int victories;
    private int defeats;
    private int torresDestruidas;
    private int inhibidoresDestruidos;
    private int dragonesAsesinados;
    private int nashorsAsesinados;
    private int heraldosAsesinados;
    private List<Jugador> roster;

    // Constructor completo
    public Equipo() {
    }

    // Constructor completo
    public Equipo(String teamName, int victories, int defeats, int torresDestruidas, int inhibidoresDestruidos,
            int dragonesAsesinados, int nashorsAsesinados, int heraldosAsesinados, List<Jugador> roster) {
        this.teamName = teamName;
        this.victories = victories;
        this.defeats = defeats;
        this.torresDestruidas = torresDestruidas;
        this.inhibidoresDestruidos = inhibidoresDestruidos;
        this.dragonesAsesinados = dragonesAsesinados;
        this.nashorsAsesinados = nashorsAsesinados;
        this.heraldosAsesinados = heraldosAsesinados;
        this.roster = roster;
    }

    // Constructor, getters y setters aquí
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getTorresDestruidas() {
        return torresDestruidas;
    }

    public void setTorresDestruidas(int torresDestruidas) {
        this.torresDestruidas = torresDestruidas;
    }

    public int getInhibidoresDestruidos() {
        return inhibidoresDestruidos;
    }

    public void setInhibidoresDestruidos(int inhibidoresDestruidos) {
        this.inhibidoresDestruidos = inhibidoresDestruidos;
    }

    public int getDragonesAsesinados() {
        return dragonesAsesinados;
    }

    public void setDragonesAsesinados(int dragonesAsesinados) {
        this.dragonesAsesinados = dragonesAsesinados;
    }

    public int getNashorsAsesinados() {
        return nashorsAsesinados;
    }

    public void setNashorsAsesinados(int nashorsAsesinados) {
        this.nashorsAsesinados = nashorsAsesinados;
    }

    public int getHeraldosAsesinados() {
        return heraldosAsesinados;
    }

    public void setHeraldosAsesinados(int heraldosAsesinados) {
        this.heraldosAsesinados = heraldosAsesinados;
    }

    public List<Jugador> getRoster() {
        return roster;
    }

    public void setRoster(List<Jugador> roster) {
        this.roster = roster;
    }

    public void reiniciarEstadisticas() {
        this.victories = 0;
        this.defeats = 0;
        this.torresDestruidas = 0;
        this.inhibidoresDestruidos = 0;
        this.dragonesAsesinados = 0;
        this.nashorsAsesinados = 0;
        this.heraldosAsesinados = 0;
        for (Jugador jugador : this.roster) {
            jugador.reiniciarEstadisticas();
        }
    }

}
