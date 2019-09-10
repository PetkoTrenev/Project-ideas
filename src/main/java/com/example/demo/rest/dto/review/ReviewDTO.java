package com.example.demo.rest.dto.review;

import com.example.demo.model.ReviewDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private String name;
    private ReviewDetails reviewDetails;

}
