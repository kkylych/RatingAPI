package com.courseWork.RatingAPI.mappers;

import com.courseWork.RatingAPI.DTOs.ProductDTO;
import com.courseWork.RatingAPI.entities.ProductEntity;

import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO toDTO(ProductEntity productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getReviewEntityList().stream()
                        .map(review -> new ReviewDTO(review.getId(), review.getComment(), review.getRating()))
                        .collect(Collectors.toList())
        );
    }

    public static ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.id());
        productEntity.setName(productDTO.name());
        productEntity.setDescription(productDTO.description());
        productEntity.setPrice(productDTO.price());
        return productEntity;
    }
}
