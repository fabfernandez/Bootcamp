package com.example.desafioquality.repositories;

import com.example.desafioquality.dtos.HotelDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelRepositoryImplTest {

    private HotelRepository hotelRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        //instanciar repository con data de prueba
        hotelRepository = new HotelRepositoryImpl("src/test/java/resources/oneHotelList.json");
    }

    @Test
    @DisplayName("Load hotels from json to POJO")
    void loadHotels() throws IOException {

        List<HotelDTO> hotels = objectMapper.readValue(
                new File("src/test/java/resources/oneHotelList.json"),
                new TypeReference<>() {
                });

        Assertions.assertEquals(hotels, hotelRepository.loadHotels());
    }
}