package com.bootcamp.fabriziodesafiospring.repositories;

import com.bootcamp.fabriziodesafiospring.entities.Article;

import java.io.FileNotFoundException;
import java.util.List;

public interface ArticleRepository {
    public List<Article> listAll() throws FileNotFoundException;
}
