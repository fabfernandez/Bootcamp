package com.bootcamp.fabriziodesafiospring.exceptions;

public class TooManyFilters extends RuntimeException {
    public TooManyFilters() {
        super("Only 2 filters are supported, for no reason.");
    }
}
