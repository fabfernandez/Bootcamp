package com.example.demo.dtos;

import com.example.demo.entities.Agenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OdontologistDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastName;
    private List<Agenda> agenda;
}
