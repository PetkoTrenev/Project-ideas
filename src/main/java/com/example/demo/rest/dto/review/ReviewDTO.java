package com.example.demo.rest.dto.review;

import com.example.demo.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Rating rating;
    private Long courseId;
    private String description;
}
