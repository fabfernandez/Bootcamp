package com.example.desafioquality.services;

import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.exceptions.CityDoesntExist;
import com.example.desafioquality.repositories.HotelRepository;

import com.example.desafioquality.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
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

        if (allParams.size() != 0) {
            return filter(output, allParams.get("dateFrom"), allParams.get("dateTo"), allParams.get("city"));
        }
        return output;
    }


    private List<HotelDTO> filter(List<HotelDTO> hotels, String dateFrom, String dateTo, String city) {
        if (cityDoesntExist(hotels, city)) throw new CityDoesntExist(city);

        return hotels.stream().filter(hotel -> meetsConditions(hotel, dateFrom, dateTo, city))
                .collect(Collectors.toList());
    }

    private boolean cityDoesntExist(List<HotelDTO> hotels, String city) {
        return hotels.stream().noneMatch(hotel -> hotel.getCity().equals(city));
    }

    private boolean meetsConditions(HotelDTO hotel, String stringDateFrom, String stringDateTo, String city) {

        LocalDate dateFrom = DateUtils.parseDate(stringDateFrom);
        LocalDate dateTo = DateUtils.parseDate(stringDateTo);
        LocalDate hotelAvailableFrom = DateUtils.parseDate(hotel.getDateFrom());
        LocalDate hotelAvailableTo = DateUtils.parseDate(hotel.getDateTo());

        return city.equals(hotel.getCity()) &&
                (dateFrom.isAfter(hotelAvailableFrom) || dateFrom.isEqual(hotelAvailableFrom)) &&
                (dateTo.isBefore(hotelAvailableTo) || dateTo.isEqual(hotelAvailableTo));
    }

}
