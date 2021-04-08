package com.bootcamp.fabriziodesafiospring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBasicDTO {
    private String productId;

    private String name;
    private String brand;
    private String quantity;

    @Override
    public String toString() {
        return "productId='" + productId + '\'' +
                ", quantity='" + quantity + '\'';
    }
}

