package com.example.demo.services;

import com.example.demo.dtos.RequestAppointmentDto;
import com.example.demo.entities.Agenda;
import com.example.demo.entities.Appointment;
import com.example.demo.entities.Patient;
import com.example.demo.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class AppointmentService implements IAppointmentService {


    @Autowired
    AgendaService agendaService;

    @Autowired
    PatientService patientService;

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(RequestAppointmentDto requestAppointmentDto) {
        Agenda agenda = agendaService.findAgenda(requestAppointmentDto.getAgendaId());
        Patient patient = patientService.findPatient(requestAppointmentDto.getPatientId());

        if(agenda == null) return null;
        if(patient == null) return null;

        Appointment appointment = new Appointment();
        appointment.setAgenda(agenda);
        appointment.setPatient(patient);


        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment deleteAppointment(Long id) {
        return null;
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        return null;
    }

    @Override
    public List<Appointment> findAllAppointments(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> findAllAppointmentsByAgendaId(Long id) {
        return null;
    }
}
