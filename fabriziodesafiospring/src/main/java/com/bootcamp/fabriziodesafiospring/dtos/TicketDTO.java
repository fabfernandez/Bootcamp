package com.bootcamp.fabriziodesafiospring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TicketDTO {
    private int id;
    List<ArticleBasicDTO> articles;
    private int total;
}
