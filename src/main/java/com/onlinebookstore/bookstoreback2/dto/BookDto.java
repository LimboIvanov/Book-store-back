package com.onlinebookstore.bookstoreback2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private Double rating;
    private Integer inventoryCount;
}
