package com.onlinebookstore.bookstoreback2.controller;

import com.onlinebookstore.bookstoreback2.dto.OrderItemDto;
import com.onlinebookstore.bookstoreback2.service.OrderItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class OrderItemController {

    private OrderItemService service;

    @PostMapping(value = "/order-items")
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemDto orderItemDto) throws Exception {
        return ResponseEntity.ok().body(service.create(orderItemDto));
    }

    @GetMapping(value = "/order-items/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemId(@PathVariable(value = "id") final Long id) throws Exception {
        OrderItemDto orderItemFound = service.findById(id);
        return ResponseEntity.ok().body(orderItemFound);
    }

    @DeleteMapping("/order-items/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/reviews")
//    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) throws Exception {
//        return ResponseEntity.ok().body(reviewService.update(reviewDto));
//    }

    @GetMapping(value = "/order-items")
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        return ResponseEntity.ok().body(service.findAll());
    }

}
