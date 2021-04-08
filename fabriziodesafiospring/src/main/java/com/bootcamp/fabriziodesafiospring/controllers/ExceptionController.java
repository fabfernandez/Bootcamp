package com.bootcamp.fabriziodesafiospring.controllers;


import com.bootcamp.fabriziodesafiospring.exceptions.*;
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
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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


    @ExceptionHandler(ArticleNotFound.class)
    public ResponseEntity<String> articleNotFound(ArticleNotFound exception) {
        exception.printStackTrace();
        System.out.println("Message: " + exception.getMessage());
        System.out.println("Exception: " + exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughStock.class)
    public ResponseEntity<String> notEnoughStock(NotEnoughStock exception) {
        exception.printStackTrace();
        System.out.println("Message: " + exception.getMessage());
        System.out.println("Exception: " + exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }


}
