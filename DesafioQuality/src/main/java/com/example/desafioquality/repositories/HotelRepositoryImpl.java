package com.example.desafioquality.repositories;

import com.example.desafioquality.dtos.HotelDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository{

    private final String path;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HotelRepositoryImpl(@Value("${hotels_path}") String path) {
        this.path = path;
    }

    @Override
    public List<HotelDTO> loadHotels() throws IOException {

        return objectMapper.readValue(
                new File(path),
                new TypeReference<List<HotelDTO>>() {
                });
    }
}
