package com.example.demo.rest;

import com.example.demo.mapper.ReviewMapper;
import com.example.demo.rest.dto.review.ReviewDTO;
import com.example.demo.service.CourseService;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/review")
public class ReviewResource {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;
    private final CourseService courseService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<ReviewDTO> saveReviewForCourse(@RequestBody ReviewDTO reviewDTO) {
        log.info("Saving review with rating {} for course with ID {}");
        return ResponseEntity.ok().build();
    }
}

