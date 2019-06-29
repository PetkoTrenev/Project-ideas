package com.example.demo.rest;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.model.Course;
import com.example.demo.rest.dto.course.CourseDTO;
import com.example.demo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private CourseService courseService;
    private CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO courseDTO) {
        Course course = courseMapper.courseDTOToCourse(courseDTO);
        CourseDTO result = courseMapper.courseToCourseDTO(courseService.save(course));
        return ResponseEntity.ok(result);
    }
}
