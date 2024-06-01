package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.dto.BookDto;
import com.onlinebookstore.bookstoreback2.dto.ReviewDto;
import com.onlinebookstore.bookstoreback2.model.Book;
import com.onlinebookstore.bookstoreback2.model.Review;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class, BookMapper.class})
public interface ReviewMapper {

//    @Mapping(target = "createdBy", ignore = true)
    Review toEntity(ReviewDto dto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Review> toEntities(List<ReviewDto> dtoList);

//    @Mapping(target = "createdBy", ignore = true)
    ReviewDto toDto(Review entity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<ReviewDto> toDtos(List<Review> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget Review book, ReviewDto reviewDto);

}
