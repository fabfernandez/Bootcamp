package com.example.desafioquality.services;

import com.example.desafioquality.dtos.BookingRequestDTO;
import com.example.desafioquality.dtos.BookingResponseDTO;
import com.example.desafioquality.dtos.HotelDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HotelService {

    List<HotelDTO> process(Map<String, String> allParams) throws IOException;

    BookingResponseDTO book(BookingRequestDTO request) throws IOException;
}
