package com.onlinebookstore.bookstoreback2.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class OrderItemDto {

    private Long id;
    private Integer quantity;
    private BookDto book;
    private BigDecimal price;
//    private OrderDto order;  // To hold the ID of the associated order
    private Long orderId;
}
