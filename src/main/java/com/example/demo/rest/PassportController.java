package com.example.demo.rest;

import com.example.demo.model.Passport;
import com.example.demo.repository.PassportRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.rest.dto.passport.PassportDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/passport")
public class PassportController {

    private PassportRepository passportRepository;
    private ModelMapper modelMapper;

    public PassportController(PassportRepository passportRepository, ModelMapper modelMapper) {
        this.passportRepository = passportRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> savePassport(@RequestBody PassportDTO passportDTO) {
        log.info("Saving passport with number {} into database", passportDTO.getNumber());
        Passport passport = passportRepository.save(createPassport(passportDTO));

        return ResponseEntity.ok(passport);
    }

    private Passport createPassport(PassportDTO passportDTO) {
        return Passport.builder()
                .number(passportDTO.getNumber()).build();
    }
}
