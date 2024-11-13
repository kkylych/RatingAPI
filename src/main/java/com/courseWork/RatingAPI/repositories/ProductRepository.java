package com.courseWork.RatingAPI.repositories;

import com.courseWork.RatingAPI.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsByName(String name);
}
