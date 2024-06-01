package com.onlinebookstore.bookstoreback2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinebookstore.bookstoreback2.model.Book;
import com.onlinebookstore.bookstoreback2.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class ReviewDto {

    private Long id;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;

    private BookDto book;

    private UserDto createdBy;

}
