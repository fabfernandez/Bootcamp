package com.bootcamp.fabriziodesafiospring.dtos;

import lombok.Data;

@Data
public class ArticleDTO {
    private String productId;

    private String name;
    private String brand;
    private String quantity;

    private String category;
    private String price;
    private String freeShipping;
    private String prestige;

    public ArticleDTO(String productId, String name, String brand, String quantity, String category, String price, String freeShipping, String prestige) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        this.prestige = prestige;

        if (freeShipping.equals("SI")) this.freeShipping = "true";
        if (freeShipping.equals("NO")) this.freeShipping = "false";
    }
}
