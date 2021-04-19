package com.example.desafioquality.exceptions;

public class WrongRoomTypeException extends RuntimeException {
    public WrongRoomTypeException(String roomType, int people) {
        super("The room type " + roomType + " is for " + people + " persons only.");
    }

    public WrongRoomTypeException(String roomType) {
        super("The " + roomType + " you want is not available on the selected dates.");
    }

    public WrongRoomTypeException() {
        super("The selected room type is not supported. Please refer to documentation.");
    }
}
