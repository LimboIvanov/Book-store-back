package com.onlinebookstore.bookstoreback2.dto.search;

import com.onlinebookstore.bookstoreback2.model.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;



@Data
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@ToString
@Slf4j
public class BookSearchDto extends GenericSearchDto<Book> {

    // Add any specific fields for filtering if needed
    private String title;
    private String author;
    private String genre;

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
    }
}

