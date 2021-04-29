package com.example.demo.controllers;

import com.example.demo.dtos.AgendaDto;
import com.example.demo.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/agenda")
public class AgendaController {
    @Autowired
    AgendaService agendaService;

    @PostMapping
    private ResponseEntity<HttpStatus> saveAppointment(@RequestBody AgendaDto agenda) {
        agendaService.saveAgenda(agenda);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
