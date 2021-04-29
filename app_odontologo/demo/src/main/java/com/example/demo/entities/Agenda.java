package com.example.demo.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @ManyToOne
    private Odontologist odontologist;
    @OneToMany(mappedBy = "id")
    private Set<Appointment> appointments;
}
