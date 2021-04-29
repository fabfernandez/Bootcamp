package com.example.demo.controllers;

import com.example.demo.dtos.RequestAppointmentDto;
import com.example.demo.entities.Appointment;
import com.example.demo.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    IAppointmentService service;

    /**
     * POST create a new appointment
     * @param requestAppointmentDto request appointment
     * @return created appointment
     */
    @PostMapping
    private ResponseEntity<Appointment> saveAppointment(@RequestBody RequestAppointmentDto requestAppointmentDto){
        return new ResponseEntity<Appointment>(service.saveAppointment(requestAppointmentDto), HttpStatus.CREATED);
    }

}
