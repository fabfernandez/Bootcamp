package com.example.desafioquality.repositories;

import com.example.desafioquality.dtos.HotelDTO;

import java.io.IOException;
import java.util.List;

public interface HotelRepository {
    List<HotelDTO> loadHotels() throws IOException;
}
