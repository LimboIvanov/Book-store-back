package com.onlinebookstore.bookstoreback2.repository;

import com.onlinebookstore.bookstoreback2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Override
    @Query("select b from Review b where b.id = :id")
    Optional<Review> findById(@Param("id") Long id);

    @Query("SELECT r FROM Review r WHERE r.book.id = :bookId")
    List<Review> findReviewsByBookId(Long bookId);

}
