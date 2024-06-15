package com.onlinebookstore.bookstoreback2.service;

import com.onlinebookstore.bookstoreback2.config.security.AuthenticationService;
import com.onlinebookstore.bookstoreback2.dto.OrderDto;
import com.onlinebookstore.bookstoreback2.dto.OrderItemDto;
import com.onlinebookstore.bookstoreback2.mapper.OrderItemMapper;
import com.onlinebookstore.bookstoreback2.mapper.OrderMapper;
import com.onlinebookstore.bookstoreback2.model.Order;
import com.onlinebookstore.bookstoreback2.model.OrderItem;
import com.onlinebookstore.bookstoreback2.repository.OrderItemRepository;
import com.onlinebookstore.bookstoreback2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderItemRepository orderItemRepository;
    private final AuthenticationService authenticationService;

    public OrderDto create(OrderDto orderDto) {
        Order order = mapper.toEntity(orderDto);
        order.setCreatedBy(authenticationService.getCurrentUserAsEntity());
        return mapper.toDto(repository.save(order));
    }

    public OrderDto findById(Long id) throws Exception {
        Order order = repository.findById(id).orElseThrow(() -> new Exception("Order#" + id + " not found"));
        return mapper.toDto(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

//    public ReviewDto update(ReviewDto reviewDto) throws Exception {
//        Review review = repository.findById(reviewDto.getId()).orElseThrow(()
//                -> new Exception("Review#" +reviewDto.getId() + " not found"));
//        mapper.update(review, reviewDto);
//        repository.save(review);
//        return mapper.toDto(review);
//    }
//
    public List<OrderDto> findAll() {
        List<Order> orders = repository.findAll();
        return mapper.toDtos(orders);
    }


    public OrderDto addOrderItem(Long orderId, OrderItemDto orderItemDto) throws Exception {
        Order order = repository.findById(orderId).orElseThrow(() -> new Exception("Order#" + orderId + " not found"));
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDto);
        orderItem.setOrder(order);
        order.getOrderItems().add(orderItem);
        return mapper.toDto(repository.save(order));
    }

    public OrderDto removeOrderItem(Long orderId, Long orderItemId) throws Exception {
        Order order = repository.findById(orderId).orElseThrow(() -> new Exception("Order#" + orderId + " not found"));
        OrderItem orderItem = order.getOrderItems().stream()
                .filter(item -> item.getId().equals(orderItemId))
                .findFirst()
                .orElseThrow(() -> new Exception("OrderItem#" + orderItemId + " not found in Order#" + orderId));

        order.getOrderItems().remove(orderItem);
        orderItemRepository.deleteById(orderItemId);

        return mapper.toDto(repository.save(order));
    }


}
