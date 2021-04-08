package com.bootcamp.fabriziodesafiospring.services;

import com.bootcamp.fabriziodesafiospring.dtos.*;
import com.bootcamp.fabriziodesafiospring.entities.Article;
import com.bootcamp.fabriziodesafiospring.exceptions.*;
import com.bootcamp.fabriziodesafiospring.repositories.ArticleRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final List<ArticleDTO> allArticles;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) throws FileNotFoundException {
        this.articleRepository = articleRepository;
        allArticles = mapIntoDtos(articleRepository.listAll());
    }

    @Override
    public List<ArticleDTO> process(Map<String, String> allParams) {

        if (allParams.containsKey("order") && allParams.size() > 3 ||
                !allParams.containsKey("order") && allParams.size() > 2) {
            throw new TooManyFilters();
        }

        List<ArticleDTO> output = allArticles;

        for (Map.Entry<String, String> param : allParams.entrySet()) {
            if (param.getKey().equals("order")) {
                continue;
            }
            output = filter(output, param.getKey(), param.getValue());
        }

        if (allParams.containsKey("order")) {
            output = order(output, allParams.get("order"));
        }

        return returnIfNotNullOrEmpty(output);
    }

    @Override
    public PurchaseResponseDTO purchase(PurchaseRequestDTO purchaseRequestDTO) {

        //generate id ticket
        int ticketId = 123;

        //check for stock available
        List<ArticleBasicDTO> requestedArticles = purchaseRequestDTO.getArticles();

        List<ArticleDTO> correspondingArticles = new ArrayList<>();

        for (ArticleBasicDTO requestedArticle : requestedArticles) {
            List<ArticleDTO> articlesFound =
                    filter(allArticles, "productId", requestedArticle.getProductId());

            if (articlesFound.isEmpty()) throw new ArticleNotFound(requestedArticle.toString());

            ArticleDTO articleFound = articlesFound.get(0);
            int availableStock = parsePrice(articleFound.getQuantity());
            int requestedStock = parsePrice(requestedArticle.getQuantity());

            if (availableStock < requestedStock) {
                throw new NotEnoughStock(requestedArticle.toString());
            }

            articleFound.setName(requestedArticle.getName());
            articleFound.setBrand(requestedArticle.getBrand());
            articleFound.setQuantity(requestedArticle.getQuantity());

            correspondingArticles.add(articleFound);
        }

        //calculate total $
        int total = 0;
        for (ArticleDTO article : correspondingArticles) {
            total = total + parsePrice(article.getPrice()) * Integer.parseInt(article.getQuantity());
        }

        //put the articles in the ticket
        TicketDTO ticket = new TicketDTO(ticketId, requestedArticles, total);

        //create status code and message
        StatusCodeDTO statusCodeDTO = new StatusCodeDTO(200, "Congratulations! Purchase Successful");

        return new PurchaseResponseDTO(ticket, statusCodeDTO);

    }

    private List<ArticleDTO> filter(List<ArticleDTO> articles, String key, String value) {

        return articles.stream().filter(article -> {
            try {
                Method method = article.getClass().getMethod("get" + StringUtils.capitalize(key));
                //return true if the value equals the method call
                return method.invoke(article).equals(value);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }).collect(Collectors.toList());
    }

    private List<ArticleDTO> order(List<ArticleDTO> list, String order) {
        switch (order) {
            case "0":
                list.sort(Comparator.comparing(ArticleDTO::getName));
                return list;
            case "1":
                list.sort(Comparator.comparing(ArticleDTO::getName));
                Collections.reverse(list);
                return list;
            case "2":
                list.sort(
                        (ArticleDTO a1, ArticleDTO a2) -> {
                            Integer price1 = parsePrice(a1.getPrice());
                            Integer price2 = parsePrice(a2.getPrice());
                            return price1.compareTo(price2);
                        });
                return list;
            case "3":
                list.sort(
                        (ArticleDTO a1, ArticleDTO a2) -> {
                            Integer price1 = parsePrice(a1.getPrice());
                            Integer price2 = parsePrice(a2.getPrice());
                            return price1.compareTo(price2);
                        });
                Collections.reverse(list);
                return list;
            default:
                throw new OrderOutOfBounds();
        }
    }

    private Integer parsePrice(String price) {
        return Integer.parseInt(price.replaceAll("[^a-zA-Z0-9]", ""));
    }

    private List<ArticleDTO> mapIntoDtos(List<Article> articles) {

        List<ArticleDTO> articleDTOS = new ArrayList<>();

        articles.forEach(article -> {
            ArticleDTO articleDTO = new ArticleDTO(
                    Integer.toString(article.getProductId()),
                    article.getName(),
                    article.getBrand(),
                    Integer.toString(article.getQuantity()),
                    article.getCategory(),
                    article.getPrice(),
                    article.getFreeShipping(),
                    article.getPrestige()
            );
            articleDTOS.add(articleDTO);
        });

        return articleDTOS;
    }

    private List<ArticleDTO> returnIfNotNullOrEmpty(List<ArticleDTO> articleDTOS) {
        if (Objects.nonNull(articleDTOS)) {
            if (!articleDTOS.isEmpty()) return articleDTOS;
        }
        throw new NoArticlesMatchFilter();
    }

}
