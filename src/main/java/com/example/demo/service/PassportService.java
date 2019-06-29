package com.example.demo.service;

import com.example.demo.model.Passport;

import java.util.Optional;

public interface PassportService {

    Passport save(Passport passport);
    Optional<Passport> get(Long id);
}
