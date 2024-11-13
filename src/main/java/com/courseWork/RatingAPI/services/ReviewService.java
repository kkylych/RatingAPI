package com.courseWork.RatingAPI.services;


import com.courseWork.RatingAPI.DTOs.ReviewDTO;
import com.courseWork.RatingAPI.entities.ProductEntity;
import com.courseWork.RatingAPI.entities.ReviewEntity;
import com.courseWork.RatingAPI.entities.UserEntity;
import com.courseWork.RatingAPI.mappers.ReviewMapper;
import com.courseWork.RatingAPI.repositories.ProductRepository;
import com.courseWork.RatingAPI.repositories.ReviewRepository;
import com.courseWork.RatingAPI.exceptions.ResourceNotFoundException;
import com.courseWork.RatingAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public ReviewDTO createReview(ReviewDTO reviewDTO, Long userId, Long productID) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        ProductEntity productEntity = productRepository.findById(productID)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productID));
        ReviewEntity reviewEntity = ReviewMapper.toEntity(reviewDTO, userEntity, productEntity);
        ReviewEntity savedReview = reviewRepository.save(reviewEntity);
        return ReviewMapper.toDTO(savedReview);
    }

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO getReviewById(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        return ReviewMapper.toDTO(reviewEntity);
    }

    public void deleteReview(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        reviewRepository.delete(reviewEntity);
    }

    public ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO) {
        ReviewEntity existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        existingReview.setContent(reviewDTO.content());
        existingReview.setRating(reviewDTO.rating());

        ReviewEntity updatedReview = reviewRepository.save(existingReview);
        return ReviewMapper.toDTO(updatedReview);
    }

    public boolean existsByProductId(Long productId) {
        return reviewRepository.existsByProductId(productId);
    }
}
