package com.example.demo.rest;

import com.example.demo.model.Passport;
import com.example.demo.model.Student;
import com.example.demo.rest.dto.passport.PassportDTO;
import com.example.demo.rest.dto.student.StudentDTO;
import com.example.demo.rest.dto.student.StudentWithPassportDTO;
import com.example.demo.rest.dto.WrapperDTO;
import com.example.demo.service.PassportService;
import com.example.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private PassportService passportService;
    private StudentService studentService;
    private ModelMapper modelMapper;

    public StudentController(PassportService passportService, StudentService studentService, ModelMapper modelMapper) {
        this.passportService = passportService;
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<WrapperDTO> getStudent(@PathVariable(value = "id") Long studentId) {
        log.info("Fetching student from database with id: {}", studentId);
        Optional<Student> optionalStudent = studentService.get(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            PassportDTO passportDTO = modelMapper.map(student.getPassport(), PassportDTO.class);
            StudentDTO studentdto = modelMapper.map(student, StudentDTO.class);
            WrapperDTO wrapperDTO = WrapperDTO.builder()
                    .studentDTO(studentdto)
                    .passportDTO(passportDTO).build();
            return ResponseEntity.ok(wrapperDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/saveWithPassport")
    public ResponseEntity<Student> saveStudentAndPassport(@RequestBody StudentWithPassportDTO studentWithPassportDTO) {
        log.info("Saving student {} with passport number {}",
                studentWithPassportDTO.getName(), studentWithPassportDTO.getPassport().getNumber());
        Passport passport = passportService.save(studentWithPassportDTO.getPassport());

        Student student = studentService.save(Student.builder()
                .name(studentWithPassportDTO.getName())
                .passport(passport).build());

        return ResponseEntity.ok(student);
    }

    @PostMapping("/save/student")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO) {
        log.info("Saving student {} into database", studentDTO.getName());
        Student student = studentService.save(createStudent(studentDTO));

        return ResponseEntity.ok(student);
    }

    private Student createStudent(StudentDTO studentDTO) {
        return Student.builder()
                .name(studentDTO.getName()).build();
    }
}