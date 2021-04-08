package com.bootcamp.fabriziodesafiospring.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

public class NotCompatibleFilters extends RuntimeException {
    public NotCompatibleFilters() {
        super("Filters are not compatible with this API, please refer to documentation.");
    }
}
