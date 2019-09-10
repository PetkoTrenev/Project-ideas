package com.example.demo.rest;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.model.Instructor;
import com.example.demo.rest.dto.instructor.InstructorDTO;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/instructors")
public class InstructorController {

    private final InstructorMapper instructorMapper;
    private final InstructorService instructorService;
    private final CourseMapper courseMapper;
    private final CategoryMapper categoryMapper;

    @PostMapping("/save")
    public ResponseEntity saveInstructor(@RequestBody InstructorDTO instructorDTO) {

        log.info("Saving instructor with name : {}" , instructorDTO.getInstructorName());
        Instructor instructor = instructorMapper.instructorDTOtoInstructor(instructorDTO);
        Course course = courseMapper.courseDTOToCourse(instructorDTO.getCourseDTO());
        Category category = categoryMapper.categoryDTOtoCategory(instructorDTO.getCourseDTO().getCategoryDTO());
        instructorService.saveInstructorWithCourse(instructor, course, category);
        return ResponseEntity.ok().build();
    }
}
