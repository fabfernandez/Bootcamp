package com.bootcamp.fabriziodesafiospring.controllers;

import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;
import com.bootcamp.fabriziodesafiospring.services.ArticleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    @MockBean
    private ArticleService articleService;

    @Autowired
    private MockMvc mockMvc;

    private static List<ArticleDTO> articlesIndumentaria;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setUp() throws IOException {

        articlesIndumentaria =
                objectMapper.readValue(new File("src/main/resources/indumentariaDTO.json"),
                        new TypeReference<>() {
                        });
    }

    @Test
    void get() throws Exception {

        //mock service
        when(articleService.process(any())).thenReturn(articlesIndumentaria);

        //get /articles
        //map into objects
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(status().isOk()).andReturn();

        List<ArticleDTO> responseArticles =
                objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
                });
        //assert equals
        Assertions.assertEquals(responseArticles, articlesIndumentaria);

        /*
        FileNotFoundException e = Assertions.assertThrows(FileNotFoundException.class,
                () -> articleService.process(null),
                "File not found expected but not thrown");
         */

    }

    @Test
    void post() {
    }
}