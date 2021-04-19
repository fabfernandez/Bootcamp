package com.example.desafioquality.services;

import com.example.desafioquality.dtos.BookingRequestDTO;
import com.example.desafioquality.dtos.BookingResponseDTO;
import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.exceptions.CityDoesntExist;
import com.example.desafioquality.exceptions.HotelNotAvailableException;
import com.example.desafioquality.exceptions.WrongRoomTypeException;
import com.example.desafioquality.repositories.HotelRepository;

import com.example.desafioquality.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    private static final Map<String, Integer> roomMap;

    static {
        roomMap = Map.of(
                "Single", 1,
                "Doble", 2,
                "Triple", 3,
                "Multiple", 4
        );
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

    @Override
    public BookingResponseDTO book(BookingRequestDTO request) throws IOException {
        List<HotelDTO> allHotels = hotelRepository.loadHotels();

        //validations here on the service layer are going to be business logic related:

        String dateFrom = request.getBooking().getDateFrom();
        String dateTo = request.getBooking().getDateTo();
        String destination = request.getBooking().getDestination();
        String hotelCode = request.getBooking().getHotelCode();

        //    validate destination
        validateCityExistence(allHotels, destination);

        //    validate if room is available for dates
        List<HotelDTO> foundHotels = filter(allHotels, dateFrom, dateTo, destination);
        if (foundHotels.isEmpty()) throw new HotelNotAvailableException(dateFrom, dateTo);

        //    validate hotelCode
        Optional<HotelDTO> requestedHotel = foundHotels.stream()
                .filter(hotel -> hotel.getHotelCode().equals(hotelCode)).findFirst();

        if (requestedHotel.isEmpty()) throw new HotelNotAvailableException(hotelCode);

        //    room type must match people.size()
        int pplQuantity = request.getBooking().getPeople().size();
        String roomType = request.getBooking().getRoomType();

        if (!roomMap.containsKey(roomType)) throw new WrongRoomTypeException();

        if (!requestedHotel.get().getRoomType().equals(roomType)) throw new WrongRoomTypeException(roomType);

        if (!roomMap.get(roomType).equals(pplQuantity))
            throw new WrongRoomTypeException(roomType, roomMap.get(roomType));

        //calculate amount based on room cost
        //calculate interest based on card type and dues
        //calculate total $

        return null;
    }


    private List<HotelDTO> filter(List<HotelDTO> hotels, String dateFrom, String dateTo, String city) {
        validateCityExistence(hotels, city);

        return hotels.stream().filter(hotel -> meetsConditions(hotel, dateFrom, dateTo, city))
                .collect(Collectors.toList());
    }

    private void validateCityExistence(List<HotelDTO> hotels, String city) {
        if (hotels.stream().noneMatch(hotel -> hotel.getCity().equals(city))) throw new CityDoesntExist(city);
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
