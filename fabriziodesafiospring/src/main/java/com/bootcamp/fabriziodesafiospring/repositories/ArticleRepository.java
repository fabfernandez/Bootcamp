package com.bootcamp.fabriziodesafiospring.repositories;

import com.bootcamp.fabriziodesafiospring.entities.Article;

import java.io.FileNotFoundException;
import java.util.List;

public interface ArticleRepository {
    List<Article> listAll() throws FileNotFoundException;
}
