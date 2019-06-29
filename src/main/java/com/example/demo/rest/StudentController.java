package com.example.demo.rest;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.rest.dto.student.StudentDTO;
import com.example.demo.service.StudentService;
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
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO) {
        log.info("Saving student: {}.", studentDTO.getName());
        Student student = studentService.save(studentMapper.studentDTOtoStudent(studentDTO));

        return ResponseEntity.ok(student);
    }
}