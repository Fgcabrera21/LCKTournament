package com.example;

public class Main {
    public static void main(String[] args) {
        // Ruta al archivo JSON con los datos de los equipos
        String archivoJSON = "C:\\Users\\Usuario\\Desktop\\Java Project\\demo\\src\\main\\java\\com\\example\\Equipos.json";

        // Crear una instancia de AplicacionTorneo y mostrar el menú principal
        AplicacionTorneo aplicacion = new AplicacionTorneo(archivoJSON);
        aplicacion.mostrarMenuPrincipal(archivoJSON);
    }
}
