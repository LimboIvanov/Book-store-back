package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
