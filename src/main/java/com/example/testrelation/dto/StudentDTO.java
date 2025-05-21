package com.example.testrelation.dto;

import com.example.testrelation.dto.simpleDTO.CourseSimpleDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String name;
    private DepartmentDTO department;
    private List<CourseSimpleDTO> courses;
}
