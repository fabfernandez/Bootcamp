package com.bootcamp.fabriziodesafiospring.exceptions;

public class ArticleNotFound extends RuntimeException {
    public ArticleNotFound(String s) {
        super("Article not found: " + s);
    }
}
