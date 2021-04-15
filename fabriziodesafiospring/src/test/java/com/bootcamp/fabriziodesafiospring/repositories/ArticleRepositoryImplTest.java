package com.bootcamp.fabriziodesafiospring.repositories;

import com.bootcamp.fabriziodesafiospring.entities.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

class ArticleRepositoryImplTest {

    private ArticleRepository articleRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        //instanciar repository con un CSV de prueba
        articleRepository = new ArticleRepositoryImpl("CSV/test.csv");
    }

    @Test
    void listAll() throws IOException {

        //traer una lista de articulos
        List<Article> makita = objectMapper.readValue(
                new File("src/main/resources/desmalezadoraMakita.json"),
                new TypeReference<>() {
                });

        //comparar
        Assertions.assertEquals(articleRepository.listAll(), makita);
    }
}