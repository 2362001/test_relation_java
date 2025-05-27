package com.example.testrelation.service;

import com.example.testrelation.dto.StudentDTO;
import com.example.testrelation.entity.StudentEntity;
import com.example.testrelation.mapper.StudentMapper;
import com.example.testrelation.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<StudentEntity> getAllStudentsWithLazy() {
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }
}
