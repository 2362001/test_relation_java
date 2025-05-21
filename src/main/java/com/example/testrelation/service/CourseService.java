package com.example.testrelation.service;

import com.example.testrelation.dto.CourseDTO;
import com.example.testrelation.mapper.CourseMapper;
import com.example.testrelation.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDTO)
                .toList();
    }
}
