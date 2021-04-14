package com.bootcamp.fabriziodesafiospring.controllers;

import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;
import com.bootcamp.fabriziodesafiospring.entities.Article;
import com.bootcamp.fabriziodesafiospring.repositories.ArticleRepository;
import com.bootcamp.fabriziodesafiospring.services.ArticleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private MockMvc mockMvc;

    private static List<Article> ej1;
    private static List<ArticleDTO> ej1DTO;

    private static List<Article> ej2;
    private static List<ArticleDTO> ej2DTO;

    private static List<Article> ej3;
    private static List<ArticleDTO> ej3DTO;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setUp() throws IOException {

        ej1 = objectMapper.readValue(new File("src/main/resources/ej1.json"),
                new TypeReference<>() {
                });
        ej1DTO = objectMapper.readValue(new File("src/main/resources/indumentariaDTO.json"),
                new TypeReference<>() {
                });

        ej2 = objectMapper.readValue(new File("src/main/resources/ej2.json"),
                new TypeReference<>() {
                });
        ej2DTO = objectMapper.readValue(new File("src/main/resources/ej2DTO.json"),
                new TypeReference<>() {
                });

        ej3 = objectMapper.readValue(new File("src/main/resources/ej3.json"),
                new TypeReference<>() {
                });
        ej3DTO = objectMapper.readValue(new File("src/main/resources/ej3DTO.json"),
                new TypeReference<>() {
                });
    }

    @Test
    void ejercicio1() throws Exception {

        //mock repository method
        when(articleRepository.listAll()).thenReturn(ej1);

        //get /articles
        //map into objects
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(status().isOk()).andReturn();

        List<ArticleDTO> responseArticles =
                objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
                });
        //assert equals
        Assertions.assertEquals(ej1DTO, responseArticles);
    }

    @Test
    void ejercicio2() throws Exception {
        //Se deberán mockear 4 productos heterogéneos donde dos pertenezcan a la categoría
        //“Herramientas”. Luego simular una llamada al controller correspondiente indicando
        //“Herramientas” como categoría de filtrado. Armar un listado que contenga los productos
        //de la categoría correcta y verificar que los devuelto por el controller sean exactamente los
        //mismos.

        //mock repository method
        when(articleRepository.listAll()).thenReturn(ej2);

        //get /articles
        //map into objects
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/articles?category=Herramientas"))
                .andExpect(status().isOk()).andReturn();

        List<ArticleDTO> responseArticles =
                objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
                });
        //assert equals
        Assertions.assertEquals(responseArticles, ej2DTO);
    }

    @Test
    void ejercicio3() throws Exception {
        //Se deberán mockear 8 productos heterogéneos donde tres pertenezcan a la categoría
        //“Herramientas” y dos incluyan “Envío Gratis”. Luego simular una llamada al controller
        //correspondiente indicando “Herramientas” y “Envío Gratis” como categorías de filtrado.
        //Armar un listado que contenga los productos de la categoría correcta y verificar que los
        //devuelto por el controller son exactamente los mismos.

        //mock repository method
        when(articleRepository.listAll()).thenReturn(ej3);

        //get /articles
        //map into objects
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/articles?category=Herramientas&freeShipping=true"))
                .andExpect(status().isOk()).andReturn();

        List<ArticleDTO> responseArticles =
                objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
                });
        //assert equals
        Assertions.assertEquals(responseArticles, ej3DTO);
    }
}
