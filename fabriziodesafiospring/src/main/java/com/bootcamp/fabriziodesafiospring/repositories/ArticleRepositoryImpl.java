package com.bootcamp.fabriziodesafiospring.repositories;

import com.bootcamp.fabriziodesafiospring.entities.Article;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private String path;

    //private MyBean mybean

    public ArticleRepositoryImpl(@Value("${articles_path:CSV/articles.csv}") String path) {
        this.path = path;
    }

    @Override
    public List<Article> listAll() throws FileNotFoundException {

        return new CsvToBeanBuilder<Article>(new FileReader(path))
                .withType(Article.class)
                .build()
                .parse();
    }
}
