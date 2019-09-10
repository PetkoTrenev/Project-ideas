package com.example.demo.rest.dto.instructor;

import com.example.demo.rest.dto.course.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    private Long id;
    private String instructorName;
    private String info;
    private CourseDTO courseDTO;
}
