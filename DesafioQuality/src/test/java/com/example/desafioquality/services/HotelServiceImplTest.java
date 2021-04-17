package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceImplTest {

    private HotelService hotelService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static List<HotelDTO> oneHotel;
    private static List<HotelDTO> aFewHotels;
    private static List<HotelDTO> cataratasHotels;


    @MockBean
    private HotelRepository hotelRepository;

    @BeforeAll
    static void setUp() throws IOException {
        oneHotel = objectMapper.readValue(
                new File("src/test/java/resources/oneHotelList.json"),
                new TypeReference<>() {
                });
        aFewHotels = objectMapper.readValue(
                new File("src/test/java/resources/aFewHotelsList.json"),
                new TypeReference<>() {
                });
        cataratasHotels = objectMapper.readValue(
                new File("src/test/java/resources/cataratasHotels.json"),
                new TypeReference<>() {
                });

    }

    @Test
    @DisplayName("When no parameters are received, list all hotels.")
    void listAll() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(oneHotel);

        hotelService = new HotelServiceImpl(hotelRepository);

        Assertions.assertEquals(oneHotel, hotelService.process(new HashMap<>()));
    }

    @Test
    @DisplayName("When dateFrom, dateTo and destination are received, filter.")
    void filterCase1() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);

        hotelService = new HotelServiceImpl(hotelRepository);

        Map<String,String> filters = new HashMap<>();
        filters.put("dateFrom", "10/02/2021");
        filters.put("dateTo", "20/03/2021");
        filters.put("city", "Puerto Iguazú");

        Assertions.assertEquals(cataratasHotels, hotelService.process(filters));
    }
}