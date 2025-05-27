package com.example.testrelation.service;

import com.example.testrelation.dto.DepartmentDTO;
import com.example.testrelation.mapper.DepartmentMapper;
import com.example.testrelation.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDTO)
                .toList();
    }
}
