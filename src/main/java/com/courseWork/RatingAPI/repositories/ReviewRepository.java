package com.courseWork.RatingAPI.repositories;

import com.courseWork.RatingAPI.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByUserId(Long userId);
}
