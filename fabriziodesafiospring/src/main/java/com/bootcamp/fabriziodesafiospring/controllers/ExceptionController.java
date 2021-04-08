package com.bootcamp.fabriziodesafiospring.controllers;


import com.bootcamp.fabriziodesafiospring.exceptions.NoArticlesMatchFilter;
import com.bootcamp.fabriziodesafiospring.exceptions.OrderOutOfBounds;
import com.bootcamp.fabriziodesafiospring.exceptions.TooManyFilters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> fileNotFound(FileNotFoundException exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    //TODO this is useless right now, app crashes on start if file is not found

    @ExceptionHandler(NoArticlesMatchFilter.class)
    public ResponseEntity<String> noArticlesMatchFilter(NoArticlesMatchFilter exception) {
        exception.printStackTrace();
        System.out.println("getMessage: " + exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(TooManyFilters.class)
    public ResponseEntity<String> tooManyFilters(TooManyFilters exception) {
        exception.printStackTrace();
        System.out.println("getMessage: " + exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderOutOfBounds.class)
    public ResponseEntity<String> orderOutOfBounds(OrderOutOfBounds exception) {
        exception.printStackTrace();
        System.out.println("getMessage: " + exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
