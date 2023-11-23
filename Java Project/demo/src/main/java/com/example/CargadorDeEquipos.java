package com.example;

import java.io.FileReader;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CargadorDeEquipos {
    public static List<Equipo> cargarEquiposDesdeJSON(String archivoJSON) {
        List<Equipo> equipos = new ArrayList<>();
        try (FileReader reader = new FileReader(archivoJSON)) {
            Type tipoListaEquipos = new TypeToken<List<Equipo>>() {
            }.getType();
            equipos = new Gson().fromJson(reader, tipoListaEquipos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }
}
