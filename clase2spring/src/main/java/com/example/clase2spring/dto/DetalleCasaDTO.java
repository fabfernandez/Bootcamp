package com.example.clase2spring.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@Builder
public class DetalleCasaDTO {
    private double metrosCuadrados;
    private double valor;
    private HabitacionDTO habitacionMasGrande;
    private Map<HabitacionDTO, Double> areaPorHabitacion;
}
