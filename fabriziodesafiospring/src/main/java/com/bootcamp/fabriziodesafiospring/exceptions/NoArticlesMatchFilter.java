package com.bootcamp.fabriziodesafiospring.exceptions;

public class NoArticlesMatchFilter extends RuntimeException {
    public NoArticlesMatchFilter() {
        super("No articles match this filters.");
    }
}
