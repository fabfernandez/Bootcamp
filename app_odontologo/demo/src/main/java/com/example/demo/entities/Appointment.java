package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Agenda agenda;
    private LocalTime timeFrom;
    private LocalTime timeTo;
}
