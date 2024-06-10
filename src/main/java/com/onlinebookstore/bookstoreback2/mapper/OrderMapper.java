package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.dto.OrderDto;
import com.onlinebookstore.bookstoreback2.model.Order;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class, BookMapper.class, OrderItemMapper.class})
public interface OrderMapper {

    Order toEntity(OrderDto dto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Order> toEntities(List<OrderDto> dtoList);

    OrderDto toDto(Order entity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<OrderDto> toDtos(List<Order> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget Order order, OrderDto orderDto);

}
