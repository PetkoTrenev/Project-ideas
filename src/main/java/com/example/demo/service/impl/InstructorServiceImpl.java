package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.model.Instructor;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;

    @Override
    public Instructor saveInstructorWithCourse(Instructor instructor, Course course, Category category) {
        Course savedCourse
                = courseRepository.save(course);
        Category savedCategory
                = categoryRepository.save(category);

        savedCourse.setCategory(savedCategory);

        if (Objects.isNull(instructor.getCourses())) {
            Set<Course> courses = new HashSet<>();
            instructor.setCourses(courses);
        } else {
            instructor.getCourses().add(savedCourse);
        }
        instructorRepository.save(instructor);
        return instructor;
    }
}
