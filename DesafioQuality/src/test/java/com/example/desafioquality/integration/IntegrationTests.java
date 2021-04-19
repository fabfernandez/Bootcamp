package com.example.desafioquality.integration;

import com.example.desafioquality.controllers.HotelController;
import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

    private static List<HotelDTO> hotels;
    private static List<HotelDTO> fakeDB;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @MockBean
    private HotelRepository hotelRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setUp() throws IOException {
        hotels =
                objectMapper.readValue(new File("src/test/java/resources/cataratasHotels.json"),
                        new TypeReference<>() {
                        });
        fakeDB =
                objectMapper.readValue(new File("src/test/java/resources/aFewHotelsList.json"),
                        new TypeReference<>() {
                        });
    }

    @Test
    void getTest() throws Exception {

        when(hotelRepository.loadHotels()).thenReturn(fakeDB);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(
                "/hotels?dateFrom=10/03/2021&dateTo=20/03/2021&city=Puerto Iguazú"))
                .andExpect(status().isOk()).andReturn();

        List<HotelDTO> responseHotels =
                objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
                });

        Assertions.assertEquals(hotels, responseHotels);
    }

}
