package com.bootcamp.fabriziodesafiospring.controllers;

import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;
import com.bootcamp.fabriziodesafiospring.dtos.PurchaseRequestDTO;
import com.bootcamp.fabriziodesafiospring.dtos.PurchaseResponseDTO;
import com.bootcamp.fabriziodesafiospring.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ArticleDTO>> getArticles(
            @RequestParam(required = false) Map<String, String> allParams) throws FileNotFoundException {
        return new ResponseEntity<>(articleService.process(allParams), HttpStatus.OK);
    }

    @PostMapping(value = "/purchase-request")
    public ResponseEntity<PurchaseResponseDTO> purchase(
            @RequestBody PurchaseRequestDTO purchaseRequestDTO) throws FileNotFoundException {
        return new ResponseEntity<>(articleService.purchase(purchaseRequestDTO), HttpStatus.OK);
    }

}
