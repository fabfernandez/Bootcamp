package com.example.desafioquality.controllers;

import com.example.desafioquality.dtos.StatusCodeDTO;
import com.example.desafioquality.exceptions.BadParametersException;
import com.example.desafioquality.exceptions.CityDoesntExist;
import com.example.desafioquality.exceptions.DateException;
import com.example.desafioquality.exceptions.InvalidEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler({BadParametersException.class, DateException.class, InvalidEmailException.class})
    public ResponseEntity<StatusCodeDTO> badRequest(RuntimeException exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(new StatusCodeDTO(400, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CityDoesntExist.class)
    public ResponseEntity<StatusCodeDTO> articleNotFound(RuntimeException exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(new StatusCodeDTO(404, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}
