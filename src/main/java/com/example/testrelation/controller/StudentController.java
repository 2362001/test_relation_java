package com.example.testrelation.controller;

import com.example.testrelation.dto.StudentDTO;
import com.example.testrelation.entity.StudentEntity;
import com.example.testrelation.repository.StudentRepository;
import com.example.testrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/lazy-get-all")
    public List<StudentEntity> getAllStudentsWithLazy() {
        return studentService.getAllStudentsWithLazy();
    }

    @GetMapping("/test-lazy-eager")
    public String testFetch() {
        List<StudentEntity> students = studentRepository.findAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Số sinh viên: ").append(students.size()).append("\n");

        for (StudentEntity s : students) {
            sb.append("Student: ").append(s.getName()).append("\n");
            sb.append("Department: ").append(s.getDepartment().getName()).append("\n");
            sb.append("Courses count: ").append(s.getCourses().size()).append("\n");
        }
        return sb.toString();
    }

}