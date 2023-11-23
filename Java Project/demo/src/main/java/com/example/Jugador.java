package com.example;

public class Jugador {
    private String playerName;
    private String role;
    private String teamName;
    private int kills;
    private int deaths;
    private int assists;
    private int totalKills;
    private int totalDeaths;
    private int totalAssists;

    // Constructor vacío
    public Jugador() {
    }

    // Constructor completo
    public Jugador(String playerName, String role, String teamName, int kills, int deaths, int assists, int totalKills,
            int totalDeaths, int totalAssists) {
        this.playerName = playerName;
        this.role = role;
        this.teamName = teamName;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.totalKills = totalKills;
        this.totalDeaths = totalDeaths;
        this.totalAssists = totalAssists;
    }

    // Getters y setters aquí
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) { // Corregido
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) { // Corregido
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) { // Corregido
        this.assists = assists;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public void reiniciarEstadisticas() {
        this.kills = 0;
        this.deaths = 0;
        this.assists = 0;
        this.totalKills = 0;
        this.totalDeaths = 0;
        this.totalAssists = 0;
    }

    public void incrementarTotales(int kills, int deaths, int assists) {
        this.totalKills += kills;
        this.totalDeaths += deaths;
        this.totalAssists += assists;
        
    }
}
