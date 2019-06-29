package com.example.demo.mapper;

import com.example.demo.model.Course;
import com.example.demo.rest.dto.course.CourseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course courseDTOToCourse(CourseDTO courseDTO);
    CourseDTO courseToCourseDTO(Course course);
}