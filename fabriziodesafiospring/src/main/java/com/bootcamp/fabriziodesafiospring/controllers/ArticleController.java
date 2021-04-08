package com.bootcamp.fabriziodesafiospring.controllers;

import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;
import com.bootcamp.fabriziodesafiospring.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // /api/v1/articles
    // /api/v1/articles?category=categoryName

    // /api/v1/articles?category=categoryName&freeShipping=true
    // /api/v1/articles?name=productName&brand=brandName

    // /api/v1/articles?category=categoryName&freeShipping=true&order=0
    // /api/v1/articles?category=categoryName&freeShipping=true&order=1

    @GetMapping(value = "/articles")
    public ResponseEntity<List<ArticleDTO>> getArticles(@RequestParam(required = false) Map<String, String> allParams)
            throws FileNotFoundException {
        System.out.println("Params size: " + allParams.size() + " and cointains: " + allParams.toString());
        return new ResponseEntity<>(articleService.process(allParams), HttpStatus.OK);
    }

}
