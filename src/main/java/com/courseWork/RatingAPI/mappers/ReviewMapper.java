package com.courseWork.RatingAPI.mappers;

import com.courseWork.RatingAPI.DTOs.ReviewDTO;
import com.courseWork.RatingAPI.entities.ReviewEntity;

public class ReviewMapper {

    public static ReviewDTO toDTO(ReviewEntity reviewEntity) {
        return new ReviewDTO(
                reviewEntity.getId(),
                reviewEntity.getContent(),
                reviewEntity.getRating()
        );
    }

    public static ReviewEntity toEntity(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(reviewDTO.id());
        reviewEntity.setContent(reviewDTO.content());
        reviewEntity.setRating(reviewDTO.rating());
        return reviewEntity;
    }
}
