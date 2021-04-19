package com.example.desafioquality.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingPetitionDTO extends BookingDTO{
    private PaymentMethodDTO paymentMethod;
}
