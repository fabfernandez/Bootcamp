package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HotelService {

    List<HotelDTO> process(Map<String, String> allParams) throws IOException;

}
