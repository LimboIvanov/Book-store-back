package com.onlinebookstore.bookstoreback2.service;

import com.onlinebookstore.bookstoreback2.dto.OrderItemDto;
import com.onlinebookstore.bookstoreback2.mapper.OrderItemMapper;
import com.onlinebookstore.bookstoreback2.model.OrderItem;
import com.onlinebookstore.bookstoreback2.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderItemService {

    private final OrderItemRepository repository;
    private final OrderItemMapper mapper;

    public OrderItemDto create(OrderItemDto orderItemDto) {
        OrderItem orderItem = mapper.toEntity(orderItemDto);
        return mapper.toDto(repository.save(orderItem));
    }

    public OrderItemDto findById(Long id) throws Exception {
        OrderItem orderItem = repository.findById(id).orElseThrow(() -> new Exception("OrderItem#" + id + " not found"));
        return mapper.toDto(orderItem);
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
    public List<OrderItemDto> findAll() {
        List<OrderItem> orderItems = repository.findAll();
        return mapper.toDtos(orderItems);
    }




}
