package com.onlinebookstore.bookstoreback2.dto;

import com.onlinebookstore.bookstoreback2.model.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class OrderDto {

    private Long id;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private UserDto createdBy;
    private List<OrderItemDto> orderItems;
//    private List<Long> orderItemIds;

}
