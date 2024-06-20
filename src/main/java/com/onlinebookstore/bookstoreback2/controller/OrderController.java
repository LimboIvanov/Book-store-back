package com.onlinebookstore.bookstoreback2.controller;

import com.onlinebookstore.bookstoreback2.dto.OrderDto;
import com.onlinebookstore.bookstoreback2.dto.OrderItemDto;
import com.onlinebookstore.bookstoreback2.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class OrderController {

    private OrderService service;

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) throws Exception {
        return ResponseEntity.ok().body(service.create(orderDto));
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(value = "id") final Long id) throws Exception {
        OrderDto orderFound = service.findById(id);
        return ResponseEntity.ok().body(orderFound);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/reviews")
//    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) throws Exception {
//        return ResponseEntity.ok().body(reviewService.update(reviewDto));
//    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<OrderDto>> getAllReviews() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping(value = "/orders/{orderId}/order-items")
    public ResponseEntity<OrderDto> addOrderItem(@PathVariable Long orderId, @RequestBody OrderItemDto orderItemDto) throws Exception {
        return ResponseEntity.ok().body(service.addOrderItem(orderId, orderItemDto));
    }

    @DeleteMapping(value = "/orders/{orderId}/order-items/{orderItemId}")
    public ResponseEntity<OrderDto> removeOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId) throws Exception {
        return ResponseEntity.ok().body(service.removeOrderItem(orderId, orderItemId));
    }

}
