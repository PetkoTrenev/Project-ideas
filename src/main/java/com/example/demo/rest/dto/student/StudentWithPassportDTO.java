package com.example.demo.rest.dto.student;

import com.example.demo.model.Passport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithPassportDTO implements Serializable {

    private String name;
    private Passport passport;
}
