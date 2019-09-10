package com.example.demo.mapper;

import com.example.demo.model.Instructor;
import com.example.demo.rest.dto.instructor.InstructorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor instructorDTOtoInstructor(InstructorDTO instructorDTO);
}
