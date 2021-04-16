package com.example.desafioquality.controllers;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.services.HotelService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class HotelControllerTest {

    private HotelController hotelController;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private HotelService hotelService;

    @Test
    void getAllHotels() throws IOException {
        List<HotelDTO> hotels = objectMapper.readValue(
                new File("src/test/java/resources/oneHotelList.json"),
                new TypeReference<>() {
                });
        //mock service method
        when(hotelService.process(any()))
                .thenReturn(hotels);

        //instance controller
        hotelController = new HotelController(hotelService);

        //assert call to controller method
        Assertions.assertEquals(hotelController.getHotels(new HashMap<>()).getBody(), hotels);

    }
}