package com.example.clase2spring.service;


import com.example.clase2spring.dto.CasaDTO;
import com.example.clase2spring.dto.DetalleCasaDTO;
import com.example.clase2spring.dto.HabitacionDTO;

import java.util.HashMap;
import java.util.Map;

public class CasaService {

    private static final double PRECIO = 800;

    public static DetalleCasaDTO getDetalle(CasaDTO casa) {

        Map<HabitacionDTO, Double> areasPorHabitacion = calcularAreaHabitaciones(casa);
        double areaTotal = calcularAreaTotal(areasPorHabitacion);

        return DetalleCasaDTO.builder()
                .areaPorHabitacion(areasPorHabitacion)
                .metrosCuadrados(areaTotal)
                .valor(calcularValor(areaTotal))
                .habitacionMasGrande(getHabitacionMasGrande(areasPorHabitacion))
                .build();
    }

    private static HabitacionDTO getHabitacionMasGrande(Map<HabitacionDTO, Double> areasPorHabitacion) {

        HabitacionDTO habitacionMasGrande = null;
        Double areaMasGrande = 0.0;

        for (Map.Entry<HabitacionDTO, Double> entry : areasPorHabitacion.entrySet()) {
            if (entry.getValue() > areaMasGrande) {
                areaMasGrande = entry.getValue();
                habitacionMasGrande = entry.getKey();
            }
        }

        return habitacionMasGrande;
    }

    private static double calcularValor(double areaTotal) {
        return areaTotal * PRECIO;
    }

    private static double calcularAreaTotal(Map<HabitacionDTO, Double> areas) {
        double areaTotal = 0;

        for (Double area : areas.values()) {
            areaTotal += area;
        }

        return areaTotal;
    }

    private static Map<HabitacionDTO, Double> calcularAreaHabitaciones(CasaDTO casa) {

        HashMap<HabitacionDTO, Double> areasPorHabitacion = new HashMap<>();

        for (HabitacionDTO habitacion : casa.getHabitaciones()) {
            areasPorHabitacion.put(habitacion, habitacion.getAncho() * habitacion.getLargo());
        }

        return areasPorHabitacion;
    }

}
