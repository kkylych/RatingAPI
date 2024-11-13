package com.courseWork.RatingAPI.mappers;

import com.courseWork.RatingAPI.DTOs.ReviewDTO;
import com.courseWork.RatingAPI.entities.ProductEntity;
import com.courseWork.RatingAPI.entities.ReviewEntity;
import com.courseWork.RatingAPI.entities.UserEntity;

public class ReviewMapper {

    public static ReviewDTO toDTO(ReviewEntity reviewEntity) {
        String author = reviewEntity.getUser().getFirstName() + " " + reviewEntity.getUser().getLastName();
        return new ReviewDTO(
                reviewEntity.getId(),
                reviewEntity.getContent(),
                reviewEntity.getRating(),
                author
        );
    }

    public static ReviewEntity toEntity(ReviewDTO reviewDTO, UserEntity userEntity, ProductEntity productEntity) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(reviewDTO.id());
        reviewEntity.setContent(reviewDTO.content());
        reviewEntity.setRating(reviewDTO.rating());
        reviewEntity.setUser(userEntity);
        reviewEntity.setProduct(productEntity);
        return reviewEntity;
    }
}

