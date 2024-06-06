package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.config.Constants;
import com.onlinebookstore.bookstoreback2.dto.ReviewDto;
import com.onlinebookstore.bookstoreback2.model.Review;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class, BookMapper.class})
public interface ReviewMapper {

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = Constants.TIME_FORMAT_DD_MM_YYYY_HH_MM_SS)
    Review toEntity(ReviewDto dto);

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = Constants.TIME_FORMAT_DD_MM_YYYY_HH_MM_SS)
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Review> toEntities(List<ReviewDto> dtoList);

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = Constants.TIME_FORMAT_DD_MM_YYYY_HH_MM_SS)
    ReviewDto toDto(Review entity);

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = Constants.TIME_FORMAT_DD_MM_YYYY_HH_MM_SS)
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<ReviewDto> toDtos(List<Review> entityList);

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = Constants.TIME_FORMAT_DD_MM_YYYY_HH_MM_SS)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget Review book, ReviewDto reviewDto);

}
