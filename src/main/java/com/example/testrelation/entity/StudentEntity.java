package com.example.testrelation.entity;

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
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Quan hệ ManyToOne với Department
    @ManyToOne(fetch = FetchType.LAZY) // EAGER để lấy luôn Department khi lấy Student
    @JoinColumn(name = "department_id") // tên cột trong bảng Student
    //    @JsonIgnore
    private DepartmentEntity department;
    //    sinh ra câu sql như ở dưới
    //    SELECT s.*, d.*
    //    FROM student s
    //    LEFT JOIN department d ON s.department_id = d.id;

    // Quan hệ ManyToMany với Course
    @ManyToMany
    @JoinTable(
            name = "student_course", // tên bảng trung gian
            joinColumns = @JoinColumn(name = "student_id"), // FK trỏ đến Student
            inverseJoinColumns = @JoinColumn(name = "course_id") // FK trỏ đến Course
    )
    //    @JsonIgnore
    private List<CourseEntity> courses = new ArrayList<>();

    // Constructor tiện tạo nhanh dữ liệu
    public StudentEntity(String name, DepartmentEntity department) {
        this.name = name;
        this.department = department;
    }
}
