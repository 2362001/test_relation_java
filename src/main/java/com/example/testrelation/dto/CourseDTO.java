package com.example.testrelation.dto;

import com.example.testrelation.dto.simpleDTO.StudentSimpleDTO;
import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String name;
    private List<StudentSimpleDTO> students;
}
