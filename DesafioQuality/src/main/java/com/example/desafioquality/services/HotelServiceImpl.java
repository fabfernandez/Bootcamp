package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelDTO> process(Map<String, String> allParams) throws IOException {

        //decide what to do with received parameters
        //do nothing or filter
        List<HotelDTO> output = hotelRepository.loadHotels();

        if (allParams.containsKey("dateFrom") &&
                allParams.containsKey("dateTo") &&
                allParams.containsKey("city") &&
                allParams.size() == 3
        ) {
            output = filter(output, allParams.get("dateFrom"), allParams.get("dateTo"), allParams.get("city"));
        }
        //TODO if allParams.size() != 0 throw new BadRequestException()
        return output;
    }


    private List<HotelDTO> filter(List<HotelDTO> hotels, String dateFrom, String dateTo, String city) {
        return hotels.stream().filter(hotel -> meetsConditions(hotel, dateFrom, dateTo, city))
                .collect(Collectors.toList());
    }

    private boolean meetsConditions(HotelDTO hotel, String stringDateFrom, String stringDateTo, String city){

        LocalDate dateFrom = parseDate(stringDateFrom);
        LocalDate dateTo = parseDate(stringDateTo);
        LocalDate hotelAvailableFrom = parseDate(hotel.getDateFrom());
        LocalDate hotelAvailableTo = parseDate(hotel.getDateTo());

        return city.equals(hotel.getCity()) &&
                (dateFrom.isAfter(hotelAvailableFrom) || dateFrom.isEqual(hotelAvailableFrom)) &&
                (dateTo.isBefore(hotelAvailableTo) || dateTo.isEqual(hotelAvailableTo));
    }

    private LocalDate parseDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
