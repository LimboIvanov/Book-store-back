package com.onlinebookstore.bookstoreback2.mapper;

import com.onlinebookstore.bookstoreback2.dto.OrderItemDto;
import com.onlinebookstore.bookstoreback2.model.OrderItem;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class, BookMapper.class, OrderMapper.class})
public interface OrderItemMapper {
    @Mapping(source = "order.id", target = "orderId")
    OrderItemDto toDto(OrderItem entity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<OrderItemDto> toDtos(List<OrderItem> entityList);

    @Mapping(source = "orderId", target = "order.id")
    OrderItem toEntity(OrderItemDto dto);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<OrderItem> toEntities(List<OrderItemDto> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void update(@MappingTarget OrderItem order, OrderItemDto orderDto);

}
