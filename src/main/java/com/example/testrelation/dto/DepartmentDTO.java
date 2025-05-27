package com.example.testrelation.dto;

import com.example.testrelation.dto.simpleDTO.StudentSimpleDTO;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;
    // getters, setters
    private List<StudentSimpleDTO> students;
}
