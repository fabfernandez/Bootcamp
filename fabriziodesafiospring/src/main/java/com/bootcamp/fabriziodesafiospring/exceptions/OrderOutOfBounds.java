package com.bootcamp.fabriziodesafiospring.exceptions;

public class OrderOutOfBounds extends RuntimeException {
    public OrderOutOfBounds() {
        super("Order is out of bounds! try again between 0 and 3");
    }
}
