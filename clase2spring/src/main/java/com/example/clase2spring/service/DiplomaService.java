package com.example.clase2spring.service;

import com.example.clase2spring.dto.AlumnoDTO;
import com.example.clase2spring.dto.AsignaturaDTO;
import com.example.clase2spring.dto.DiplomaDTO;

import java.util.List;


public class DiplomaService {
    public static DiplomaDTO getDiploma(AlumnoDTO alumno) {

        double promedio = calcularPromedio(alumno.getAsignaturasAprobadas());

        DiplomaDTO diploma = new DiplomaDTO();
        diploma.setAlumno(alumno.getNombre());
        diploma.setPromedio(promedio);

        if (promedio > 9) {
            diploma.setMensaje(String.format("Felicitaciones, " + alumno.getNombre() + ". Promedio " + promedio));
        } else {
            diploma.setMensaje("Alumno " + alumno.getNombre() + ". Aprobado con promedio: " + promedio);
        }

        return diploma;
    }

    private static double calcularPromedio(List<AsignaturaDTO> asignaturas) {

        double suma = 0;

        for (AsignaturaDTO asignatura : asignaturas) {

            suma += asignatura.getNota();
        }

        return suma / asignaturas.size();
    }
}
