package com.example.demo.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Odontologist{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dni;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "id")
    private Set<Agenda> agenda;
}
