package com.example.clase2spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDTO {
    private String nombre;
    private double largo;
    private double ancho;
}
