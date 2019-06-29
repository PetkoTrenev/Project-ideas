package com.example.demo.rest.dto;


import com.example.demo.rest.dto.passport.PassportDTO;
import com.example.demo.rest.dto.student.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WrapperDTO implements Serializable {

    private StudentDTO studentDTO;
    private PassportDTO passportDTO;
}
