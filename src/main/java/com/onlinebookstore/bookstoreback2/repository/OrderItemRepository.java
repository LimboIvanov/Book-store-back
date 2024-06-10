package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
