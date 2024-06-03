package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    @Override
    @Query("select b from Book b where b.id = :id")
    Optional<Book> findById(@Param("id") Long id);

    @Query("select b from Book b where b.price > :price")
    List<Book> findBooksByPriceGreaterThan(@Param("price") BigDecimal price);

    @Query("select b from Book b where b.price < :price")
    List<Book> findBooksByPriceLessThan(@Param("price") BigDecimal price);

}
