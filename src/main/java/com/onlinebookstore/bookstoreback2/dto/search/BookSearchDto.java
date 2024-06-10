package com.onlinebookstore.bookstoreback2.dto.search;

import com.onlinebookstore.bookstoreback2.model.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;



@Data
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@ToString
@Slf4j
public class BookSearchDto extends GenericSearchDto<Book> {
    private String title;
    private String author;
    private String genre;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Double rating;
    private BigDecimal price;

    protected void addFiltersInternal(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, List<Predicate> filters) {
        if (title != null && !title.isEmpty()) {
            filters.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
        }
        if (author != null && !author.isEmpty()) {
            filters.add(criteriaBuilder.like(root.get("author"), "%" + author + "%"));
        }
        if (genre != null && !genre.isEmpty()) {
            filters.add(criteriaBuilder.equal(root.get("genre"), genre));
        }
        if (minPrice != null) {
            filters.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            filters.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        if (rating != null) {
            filters.add(criteriaBuilder.equal(root.get("rating"), rating));
        }

        if (price != null) {
            filters.add(criteriaBuilder.equal(root.get("price"), price));
        }
    }
}

