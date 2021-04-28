package com.example.demo.services;

import com.example.demo.entities.Agenda;
import com.example.demo.entities.Appointment;
import com.example.demo.entities.Odontologist;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAgendaService {

    void saveAgenda(Agenda agenda);

    void deleteAgenda(Long id);

    Agenda findAgenda(Long id);

    List<Agenda> getAllAgendas();

    void patchAppointments(Long id, Set<Appointment> appointments);

    void putAgenda(Agenda newAgenda);
}
