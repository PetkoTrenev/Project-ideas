package com.example.demo.rest;

import com.example.demo.mapper.ReviewMapper;
import com.example.demo.model.Course;
import com.example.demo.model.Review;
import com.example.demo.rest.dto.review.ReviewDTO;
import com.example.demo.service.CourseService;
import com.example.demo.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/review")
public class ReviewResource {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;
    private final CourseService courseService;

    public ReviewResource(ReviewService reviewService, ReviewMapper reviewMapper, CourseService courseService) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
        this.courseService = courseService;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<ReviewDTO> saveReviewForCourse(@RequestBody ReviewDTO reviewDTO) {
        log.info("Saving review with rating {} for course with ID {}", reviewDTO.getRating(), reviewDTO.getCourseId());
        Optional<Course> optionalCourse =
                courseService.get(reviewDTO.getCourseId());

        Review review = reviewMapper.reviewDTOtoReview(reviewDTO);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            review.setCourse(course);
            reviewService.save(review);
//            course.getReviews().add(review);
//            review.setCourse(course);
//            courseService.save(course);
        }

        return ResponseEntity.ok(reviewMapper.reviewToReviewDTO(review));
    }
}

