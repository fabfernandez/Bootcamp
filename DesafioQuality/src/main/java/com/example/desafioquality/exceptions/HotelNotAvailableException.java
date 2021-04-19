package com.example.desafioquality.exceptions;

public class HotelNotAvailableException extends RuntimeException {
    public HotelNotAvailableException(String dateFrom, String dateTo) {
        super("No rooms are available from " + dateFrom + " to " + dateTo);
    }

    public HotelNotAvailableException(String hotelCode) {
        super("Hotel code " + hotelCode + " is not available for the selected dates.");
    }
}
