package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class RequestAppointmentDto {

    private Long patientId;
    private Long agendaId;
    private LocalTime timeFrom;
    private LocalTime timeTo;

}
