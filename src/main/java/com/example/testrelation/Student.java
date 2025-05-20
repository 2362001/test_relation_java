package com.example.testrelation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Quan hệ ManyToOne với Department
    @ManyToOne
    @JoinColumn(name = "department_id") // tên cột trong bảng Student
    private Department department;

    // Quan hệ ManyToMany với Course
    @ManyToMany
    @JoinTable(
            name = "student_course", // tên bảng trung gian
            joinColumns = @JoinColumn(name = "student_id"), // FK trỏ đến Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // FK trỏ đến Course
    )
    private List<Course> courses = new ArrayList<>();

    // Constructor tiện tạo nhanh dữ liệu
    public Student(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}
