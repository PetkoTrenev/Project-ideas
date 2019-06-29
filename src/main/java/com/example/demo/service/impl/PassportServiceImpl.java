package com.example.demo.service.impl;

import com.example.demo.model.Passport;
import com.example.demo.repository.PassportRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Optional<Passport> get(Long id) {
        return passportRepository.findById(id);
    }
}
