package com.example.demo.services;

import com.example.demo.dtos.RequestAppointmentDto;
import com.example.demo.entities.Appointment;

import java.util.List;

public interface IAppointmentService {
    Appointment saveAppointment(RequestAppointmentDto requestAppointmentDto);
    Appointment updateAppointment(Appointment appointment);
    Appointment deleteAppointment(Long id);
    Appointment findAppointmentById(Long id);
    List<Appointment> findAllAppointments(Appointment appointment);
    List<Appointment> findAllAppointmentsByAgendaId(Long id);
}
