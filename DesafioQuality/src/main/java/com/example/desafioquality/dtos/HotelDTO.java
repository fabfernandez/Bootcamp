package com.example.desafioquality.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String hotelCode;
    private String name;
    private String city;
    private String roomType;
    private String price;
    private String dateFrom;
    private String dateTo;
    private String reserved;
}


