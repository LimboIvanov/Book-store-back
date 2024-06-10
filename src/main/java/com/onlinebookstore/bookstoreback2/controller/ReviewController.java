package com.onlinebookstore.bookstoreback2.controller;

import com.onlinebookstore.bookstoreback2.dto.ReviewDto;
import com.onlinebookstore.bookstoreback2.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping(value = "/reviews")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) throws Exception {
        return ResponseEntity.ok().body(reviewService.create(reviewDto));
    }

    @GetMapping(value = "/reviews/{id}")
    public ResponseEntity<ReviewDto> getReviewId(@PathVariable(value = "id") final Long id) throws Exception {
        ReviewDto reviewFound = reviewService.findReviewById(id);
        return ResponseEntity.ok().body(reviewFound);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/reviews")
    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) throws Exception {
        return ResponseEntity.ok().body(reviewService.update(reviewDto));
    }

    @GetMapping(value = "/reviews")
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        return ResponseEntity.ok().body(reviewService.findAllReviews());
    }

    @GetMapping(value = "/reviews-by-book/{bookId}")
    public ResponseEntity<List<ReviewDto>> getAllReviewsByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(reviewService.findAllReviewsByBookId(bookId));
    }

}
