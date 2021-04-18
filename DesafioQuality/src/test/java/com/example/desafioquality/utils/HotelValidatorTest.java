package com.example.desafioquality.utils;

import com.example.desafioquality.exceptions.BadParametersException;
import com.example.desafioquality.exceptions.DateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HotelValidatorTest {

    @Test
    @DisplayName("When 4 parameters are passed then throw exception.")
    void tooManyParameters() {
        Map<String, String> params = new HashMap<>();
        params.put("1", "asd");
        params.put("2", "asd");
        params.put("3", "asd");
        params.put("4", "asd");

        assertThrows(BadParametersException.class, () -> HotelValidator.validateParameters(params));
    }

    @Test
    @DisplayName("When 2 parameters are passed then throw exception.")
    void tooFewParameters() {
        Map<String, String> params = new HashMap<>();
        params.put("asd1", "asd");
        params.put("asd2", "asd");

        assertThrows(BadParametersException.class, () -> HotelValidator.validateParameters(params));
    }

    @Test
    @DisplayName("When 3 parameters are passed and any of them has a wrong name then throw exception.")
    void wrongParameterName() {
        Map<String, String> params = new HashMap<>();
        params.put("dateFrom", "10/03/2021");
        params.put("dateTo", "12/03/2021");
        params.put("ASDASDADSS", "Buenos Aires");

        assertThrows(BadParametersException.class, () -> HotelValidator.validateParameters(params));
    }

    @Test
    @DisplayName("When dateTo is before dateFrom then throw exception.")
    void dateToBeforeDateFrom() {
        Map<String, String> params = new HashMap<>();
        params.put("dateFrom", "10/03/2021");
        params.put("dateTo", "09/03/2021");
        params.put("city", "Buenos Aires");

        assertThrows(DateException.class, () -> HotelValidator.validateParameters(params));
    }

    @Test
    @DisplayName("When date format is wrong then throw exception.")
    void wrongDateFormat() {
        Map<String, String> params = new HashMap<>();
        params.put("dateFrom", "2021/10/2");
        params.put("dateTo", "10/03/2021");
        params.put("city", "Buenos Aires");

        assertThrows(DateException.class, () -> HotelValidator.validateParameters(params));
    }

    @Test
    @DisplayName("When city has unsupported characters then throw exception")
    void cityUnsupportedCharacters() {
        Map<String, String> params = new HashMap<>();
        params.put("dateFrom", "10/03/2021");
        params.put("dateTo", "12/03/2021");
        params.put("city", ";");

        assertThrows(BadParametersException.class, () -> HotelValidator.validateParameters(params));
    }

}