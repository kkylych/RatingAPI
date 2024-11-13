package com.courseWork.RatingAPI.DTOs;

public record ReviewDTO(Long id, String content, int rating, String author) {
}
