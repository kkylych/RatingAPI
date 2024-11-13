package com.courseWork.RatingAPI.mappers;

import com.courseWork.RatingAPI.DTOs.ProductDTO;
import com.courseWork.RatingAPI.DTOs.ReviewDTO;
import com.courseWork.RatingAPI.entities.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO toDTO(ProductEntity productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getReviewEntityList() != null ? productEntity.getReviewEntityList().stream()
                        .map(ReviewMapper::toDTO)
                        .collect(Collectors.toList()) : List.of()
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
