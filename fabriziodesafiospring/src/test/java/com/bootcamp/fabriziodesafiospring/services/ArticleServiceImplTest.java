package com.bootcamp.fabriziodesafiospring.services;

import com.bootcamp.fabriziodesafiospring.repositories.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ArticleServiceImplTest {

    @MockBean
    private ArticleRepository articleRepository;

    @Test
    void allArticles() {
        //keep in mind that the cvs is loaded upon ArticleServiceImpl construction
        //will the mock work?

        //load json files

        //when(articleRepository.listAll(any())).thenReturn()

        //create Service bean

        //hit service

        //assert


    }

    @Test
    void filterByCategory() {
    }

    @Test
    void filterBy1() {
    }

    @Test
    void filterBy2() {
    }

    @Test
    void filterBy3() {
    }

    @Test
    void orderBy0() {
    }

    @Test
    void orderBy1() {
    }

    @Test
    void orderBy2() {
    }

    @Test
    void orderBy3() {
    }

    @Test
    void orderByAndFilterBy1() {
    }

    @Test
    void orderByAndFilterBy2() {
    }

    @Test
    void orderByAndFilterBy3() {
    }

    @Test
    void purchase() {
    }
}