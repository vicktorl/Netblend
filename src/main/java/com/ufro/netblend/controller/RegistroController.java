package com.ufro.netblend.controller;

import com.ufro.netblend.models.Registro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RegistroController {

    public static List<Registro> obtenerUltimos10Usuarios(List<Registro> registros) {
        registros.sort(Comparator.comparing(Registro::getUltima_conexion).reversed()); // Ordenar por fecha de última conexión en orden descendente
        return registros.subList(0, Math.min(registros.size(), 10)); // Obtener los primeros 10 registros (o menos si hay menos de 10 registros)
    }
    public static List<Registro> obtenerUsuariosPopulares(List<Registro> registros) {
        registros.sort(Comparator.comparingInt(registro -> registro.getSiguiendo().size())); // Ordenar por la cantidad de seguidores en orden ascendente
        int maxSeguidores = registros.get(registros.size() - 1).getSiguiendo().size(); // Obtener la cantidad máxima de seguidores

        // Filtrar los registros que tienen la cantidad máxima de seguidores
        List<Registro> usuariosPopulares = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro.getSiguiendo().size() == maxSeguidores) {
                usuariosPopulares.add(registro);
            } else {
                break; // Romper el bucle al encontrar registros con menos seguidores
            }
        }

        return usuariosPopulares;
}}
