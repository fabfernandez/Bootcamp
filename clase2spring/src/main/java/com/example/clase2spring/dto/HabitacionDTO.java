package com.example.clase2spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitacionDTO {
    private String nombre;
    private double largo;
    private double ancho;
}
