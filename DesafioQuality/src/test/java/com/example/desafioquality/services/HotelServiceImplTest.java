package com.example.desafioquality.services;

import com.example.desafioquality.dtos.BookingRequestDTO;
import com.example.desafioquality.dtos.HotelDTO;
import com.example.desafioquality.exceptions.CityDoesntExist;
import com.example.desafioquality.exceptions.HotelNotAvailableException;
import com.example.desafioquality.exceptions.WrongRoomTypeException;
import com.example.desafioquality.repositories.HotelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

class HotelServiceImplTest {

    private HotelService hotelService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static List<HotelDTO> oneHotel;
    private static List<HotelDTO> aFewHotels;
    private static List<HotelDTO> cataratasHotels;

    private final HotelRepository hotelRepository = Mockito.mock(HotelRepository.class);

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

        Map<String, String> filters = new HashMap<>();
        filters.put("dateFrom", "10/02/2021");
        filters.put("dateTo", "20/03/2021");
        filters.put("city", "Puerto Iguazú");

        Assertions.assertEquals(cataratasHotels, hotelService.process(filters));
    }

    @Test
    @DisplayName("When destination received in process method doesnt exist, throw exception.")
    void unknownDestinationProcess() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        Map<String, String> filters = new HashMap<>();
        filters.put("dateFrom", "10/02/2021");
        filters.put("dateTo", "20/03/2021");
        filters.put("city", "Ciudad Falsa");

        Assertions.assertThrows(CityDoesntExist.class, () -> hotelService.process(filters));
    }

    @Test
    @DisplayName("When destination received in book method doesnt exist, throw exception.")
    void unknownDestinationBooking() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestWrongDestination.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(CityDoesntExist.class, () -> hotelService.book(request));
    }

    @Test
    @DisplayName("When no hotel is available in the selected dates then throw exception.")
    void noHotelsInSelectedDates() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestWrongDates.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(HotelNotAvailableException.class, () -> hotelService.book(request));
    }

    @Test
    @DisplayName("When hotel code is not found between selected dates then throw exception.")
    void noHotelCodeInSelectedDates() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestWrongCode.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(HotelNotAvailableException.class, () -> hotelService.book(request));
    }

    @Test
    @DisplayName("When roomType is unknown then throw exception.")
    void unknownRoomType() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestWrongRoomType.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(WrongRoomTypeException.class, () -> hotelService.book(request));
    }

    @Test
    @DisplayName("When selected RoomType is Triple but the available room is Doble then throw exception.")
    void selectedRoomTypeNotAvailable() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestAnotherRoomType.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(WrongRoomTypeException.class, () -> hotelService.book(request));
    }

    @Test
    @DisplayName("When selected roomType doesn't match the number of people in the request then throw exception.")
    void roomTypeTooSmall() throws IOException {

        when(hotelRepository.loadHotels()).thenReturn(aFewHotels);
        hotelService = new HotelServiceImpl(hotelRepository);

        //load request from json
        BookingRequestDTO request = objectMapper.readValue(
                new File("src/test/java/resources/testBookingRequestSingleFor2.json"),
                new TypeReference<>() {
                });
        Assertions.assertThrows(WrongRoomTypeException.class, () -> hotelService.book(request));
    }

}