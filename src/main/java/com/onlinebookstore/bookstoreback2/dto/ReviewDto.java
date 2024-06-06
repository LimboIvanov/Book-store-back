package com.onlinebookstore.bookstoreback2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    private BookDto book;

    private UserDto createdBy;

}
