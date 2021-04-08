package com.bootcamp.fabriziodesafiospring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponseDTO {
    private TicketDTO ticket;
    private StatusCodeDTO statusCode;
}
