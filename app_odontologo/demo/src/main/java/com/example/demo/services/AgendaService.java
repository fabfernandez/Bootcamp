package com.example.demo.services;

import com.example.demo.dtos.AgendaDto;
import com.example.demo.entities.Agenda;
import com.example.demo.entities.Appointment;
import com.example.demo.entities.Odontologist;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repository.IAgendaRepository;
import com.example.demo.repository.IOdontologistRepository;
import com.example.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AgendaService implements IAgendaService {

    private final IAgendaRepository repository;
    private final IOdontologistRepository odontologistRepository;

    @Autowired
    public AgendaService(IAgendaRepository repository, IOdontologistRepository odontologistRepository) {
        this.repository = repository;
        this.odontologistRepository = odontologistRepository;
    }

    @Override
    @Transactional
    public void saveAgenda(AgendaDto agenda) {
        Agenda agendaToCreate = new Agenda();
        Odontologist odontologist = odontologistRepository.findById(agenda.getOdontologistId()).orElseThrow();
        agendaToCreate.setOdontologist(odontologist);
        try {
            agendaToCreate.setDate(DateUtils.getDateFromString(agenda.getDate()));
        } catch (ApiException e) {
            e.printStackTrace();
        }
        repository.save(agendaToCreate);
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
    public void patchAppointments(Long id, Set<Appointment> appointments) {
        Agenda agenda = repository.findById(id).orElseThrow();
        agenda.setAppointments(appointments);
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
