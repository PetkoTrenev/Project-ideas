package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.model.Instructor;

public interface InstructorService {

    Instructor saveInstructorWithCourse(Instructor instructor, Course course, Category category);
}
