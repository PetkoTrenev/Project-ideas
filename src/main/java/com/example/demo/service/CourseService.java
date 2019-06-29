package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.Optional;

public interface CourseService {

    Course save(Course course);
    Optional<Course> get(Long courseId);
}
