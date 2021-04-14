package com.bootcamp.fabriziodesafiospring.services;


import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;
import com.bootcamp.fabriziodesafiospring.dtos.PurchaseRequestDTO;
import com.bootcamp.fabriziodesafiospring.dtos.PurchaseResponseDTO;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface ArticleService {
    List<ArticleDTO> process(Map<String, String> allParams) throws FileNotFoundException;

    PurchaseResponseDTO purchase(PurchaseRequestDTO purchaseRequestDTO) throws FileNotFoundException;
}
