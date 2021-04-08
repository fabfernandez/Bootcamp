package com.bootcamp.fabriziodesafiospring.exceptions;

public class NotEnoughStock extends RuntimeException {
    public NotEnoughStock(String s) {
        super("Not enough stock on article: " + s);
    }
}
