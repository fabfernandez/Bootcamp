package com.example.desafioquality.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private String userName;
    private double amount;
    private double interest;
    private double total;
    private BookingDTO bookingDTO;
    private StatusCodeDTO statusCodeDTO;
}
