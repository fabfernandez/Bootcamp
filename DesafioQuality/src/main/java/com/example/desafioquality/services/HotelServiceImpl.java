package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    private List<HotelDTO> allHotels;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelDTO> process(Map<String, String> allParams) throws IOException {

        //decide what to do with received parameters
        //listAll or filter

        return listAll();
    }

    private List<HotelDTO> listAll() throws IOException {
        return hotelRepository.loadHotels();
    }
}
