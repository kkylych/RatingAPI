package com.courseWork.RatingAPI.controllers;

import com.courseWork.RatingAPI.DTOs.ReviewDTO;
import com.courseWork.RatingAPI.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Object> createReview(@RequestParam Long userId, @RequestParam Long productId, @RequestBody ReviewDTO reviewDTO) {
        if (reviewService.existsByProductId(productId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Отзыв от этого пользователя на продукт уже существует");
        }
        return ResponseEntity.ok(reviewService.createReview(reviewDTO, userId, productId));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.updateReview(id, reviewDTO));
    }
}