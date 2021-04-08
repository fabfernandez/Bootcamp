package com.bootcamp.fabriziodesafiospring.services;


import com.bootcamp.fabriziodesafiospring.dtos.ArticleDTO;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    List<ArticleDTO> process(Map<String, String> allParams);
}
