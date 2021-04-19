package com.example.desafioquality.controllers;


import com.example.desafioquality.dtos.BookingRequestDTO;
import com.example.desafioquality.dtos.BookingResponseDTO;
import com.example.desafioquality.dtos.HotelDTO;

import com.example.desafioquality.services.HotelService;
import com.example.desafioquality.utils.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // get /hotels
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> getHotels(
            @RequestParam(required = false) Map<String, String> allParams) throws IOException {

        HotelValidator.validateParameters(allParams);
        return new ResponseEntity<>(hotelService.process(allParams), HttpStatus.OK);
    }

    // post /booking
    @PostMapping("/booking")
    public ResponseEntity<BookingResponseDTO> book(@RequestBody BookingRequestDTO request) throws IOException {

        //todo: validate request
        return new ResponseEntity<>(hotelService.book(request), HttpStatus.OK);
    }
}
