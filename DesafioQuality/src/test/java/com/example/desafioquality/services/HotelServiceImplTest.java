package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;
import com.example.desafioquality.repositories.HotelRepositoryImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceImplTest {
    private HotelService hotelService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static List<HotelDTO> hotels;

    @MockBean
    private HotelRepository hotelRepository;

    @BeforeAll
    static void setUp() throws IOException {
        hotels = objectMapper.readValue(
                new File("src/test/java/resources/oneHotelList.json"),
                new TypeReference<>() {
                });
    }

    @Test
    void listAll() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(hotels);

        hotelService = new HotelServiceImpl(hotelRepository);

        Assertions.assertEquals(hotelService.process(new HashMap<>()), hotels);
    }
}