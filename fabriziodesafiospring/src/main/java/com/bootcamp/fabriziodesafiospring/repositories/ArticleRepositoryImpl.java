package com.bootcamp.fabriziodesafiospring.repositories;

import com.bootcamp.fabriziodesafiospring.entities.Article;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private static final String FILE_PATH = "CSV/articles.csv";
    //TODO move this to application.properties

    @Override
    public List<Article> listAll() throws FileNotFoundException {

        List<Article> beans = new CsvToBeanBuilder(new FileReader(FILE_PATH))
                .withType(Article.class)
                .build()
                .parse();

        return beans;
    }
}
