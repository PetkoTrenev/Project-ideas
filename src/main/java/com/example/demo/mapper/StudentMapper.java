package com.example.demo.mapper;

import com.example.demo.model.Student;
import com.example.demo.rest.dto.student.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student studentDTOtoStudent(StudentDTO studentDTO);
}
