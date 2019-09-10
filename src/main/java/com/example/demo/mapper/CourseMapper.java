package com.example.demo.mapper;

import com.example.demo.model.Course;
import com.example.demo.rest.dto.course.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "courseName", target = "name")
    Course courseDTOToCourse(CourseDTO courseDTO);
    CourseDTO courseToCourseDTO(Course course);
}