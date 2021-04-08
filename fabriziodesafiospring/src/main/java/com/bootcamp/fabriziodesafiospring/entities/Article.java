package com.bootcamp.fabriziodesafiospring.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Article {
    @CsvBindByName
    private int productId;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String category;
    @CsvBindByName
    private String brand;
    @CsvBindByName
    private String price;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    private String freeShipping;
    @CsvBindByName
    private String prestige;
}
