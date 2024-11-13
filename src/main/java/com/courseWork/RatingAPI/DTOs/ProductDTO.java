package com.courseWork.RatingAPI.DTOs;

import java.util.List;

public record ProductDTO(Long id, String name, String description, double price, List<ReviewDTO> reviews) {
}
