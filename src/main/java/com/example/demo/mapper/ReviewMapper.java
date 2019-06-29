package com.example.demo.mapper;

import com.example.demo.model.Review;
import com.example.demo.rest.dto.review.ReviewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review reviewDTOtoReview(ReviewDTO reviewDTO);

    ReviewDTO reviewToReviewDTO(Review review);
}
