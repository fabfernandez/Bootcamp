package com.example.demo.services;

import com.example.demo.entities.Agenda;
import com.example.demo.entities.Appointment;
import com.example.demo.entities.Odontologist;
import com.example.demo.repository.IAgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AgendaService implements IAgendaService {

    private final IAgendaRepository repository;

    @Autowired
    public AgendaService(IAgendaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void saveAgenda(Agenda agenda) {
        repository.save(agenda);
    }

    @Override
    @Transactional
    public void deleteAgenda(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Agenda findAgenda(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agenda> getAllAgendas() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void patchAgenda(Long id, LocalDate date, Odontologist odontologist, Set<Appointment> appointments) {
        Agenda agenda = repository.findById(id).orElseThrow();
        agenda.setAppointments(appointments);
        agenda.setDate(date);
        agenda.setOdontologist(odontologist);
        repository.save(agenda);
    }

    @Override
    @Transactional
    public void putAgenda(Agenda newAgenda) {
        //find an Agenda with the same id
        repository.findById(newAgenda.getId()).orElseThrow();
        //overwrite it
        repository.save(newAgenda);
    }
}
