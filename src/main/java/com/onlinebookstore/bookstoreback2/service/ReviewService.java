package com.onlinebookstore.bookstoreback2.service;

import com.onlinebookstore.bookstoreback2.dto.ReviewDto;
import com.onlinebookstore.bookstoreback2.mapper.ReviewMapper;
import com.onlinebookstore.bookstoreback2.model.Review;
import com.onlinebookstore.bookstoreback2.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    public ReviewDto create(ReviewDto reviewDto) {
        System.out.println(reviewDto);
//        System.out.println(reviewDto.getBook());
        Review review = mapper.toEntity(reviewDto);
        System.out.println("FIRST 1111111");
        System.out.println(review.getBook());
        return mapper.toDto(repository.save(review));
    }

    public ReviewDto findReviewById(Long id) throws Exception {
        Review review = repository.findById(id).orElseThrow(() -> new Exception("Review#" + id + " not found"));
        return mapper.toDto(review);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ReviewDto update(ReviewDto reviewDto) throws Exception {
        Review review = repository.findById(reviewDto.getId()).orElseThrow(()
                -> new Exception("Review#" +reviewDto.getId() + " not found"));
        mapper.update(review, reviewDto);
        repository.save(review);
        return mapper.toDto(review);
    }

    public List<ReviewDto> findAllReviews() {
        List<Review> reviews = repository.findAll();
        return mapper.toDtos(reviews);
    }

    public List<ReviewDto> findAllReviewsByBookId(Long bookId) {
        List<Review> reviews = repository.findReviewsByBookId(bookId);
        return mapper.toDtos(reviews);
    }


}
