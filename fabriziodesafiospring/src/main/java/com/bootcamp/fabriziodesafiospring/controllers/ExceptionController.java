package com.bootcamp.fabriziodesafiospring.controllers;


import com.bootcamp.fabriziodesafiospring.dtos.StatusCodeDTO;
import com.bootcamp.fabriziodesafiospring.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler({NoArticlesMatchFilter.class, NotEnoughStock.class})
    public ResponseEntity<StatusCodeDTO> noArticlesMatchFilter(Exception exception) {
        exception.printStackTrace();
        System.out.println("getMessage: " + exception.getMessage());

        return new ResponseEntity<>(new StatusCodeDTO(200, exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler({TooManyFilters.class, OrderOutOfBounds.class})
    public ResponseEntity<StatusCodeDTO> tooManyFilters(Exception exception) {
        exception.printStackTrace();
        System.out.println("getMessage: " + exception.getMessage());
        return new ResponseEntity<>(new StatusCodeDTO(400, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticleNotFound.class)
    public ResponseEntity<StatusCodeDTO> articleNotFound(ArticleNotFound exception) {
        exception.printStackTrace();
        System.out.println("Message: " + exception.getMessage());
        System.out.println("Exception: " + exception);
        return new ResponseEntity<>(new StatusCodeDTO(404, exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
