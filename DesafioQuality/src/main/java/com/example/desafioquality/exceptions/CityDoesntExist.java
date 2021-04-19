package com.example.desafioquality.exceptions;

public class CityDoesntExist extends RuntimeException {
    public CityDoesntExist(String city) {
        super("The city " + city + " doesn't exist in our database. Please check the spelling.");
    }
}
