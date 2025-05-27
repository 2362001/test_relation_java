package com.example.testrelation;

import com.example.testrelation.entity.CourseEntity;
import com.example.testrelation.entity.DepartmentEntity;
import com.example.testrelation.entity.StudentEntity;
import com.example.testrelation.repository.CourseRepository;
import com.example.testrelation.repository.DepartmentRepository;
import com.example.testrelation.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class TestrelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestrelationApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(DepartmentRepository departmentRepo, StudentRepository studentRepo, CourseRepository courseRepo) {
        return args -> {
            // Tạo 10 Department
            List<DepartmentEntity> departments = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                departments.add(new DepartmentEntity("Department " + i));
            }
            departmentRepo.saveAll(departments);

            // Tạo 10 Course
            List<CourseEntity> courses = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                courses.add(new CourseEntity("Course " + i));
            }
            courseRepo.saveAll(courses);

            // Tạo 10 Student, gán Department và Course ngẫu nhiên
            List<StudentEntity> students = new ArrayList<>();
            Random rand = new Random();

            for (int i = 1; i <= 10; i++) {
                // Lấy department ngẫu nhiên
                DepartmentEntity randomDept = departments.get(rand.nextInt(departments.size()));
                StudentEntity student = new StudentEntity("Student " + i, randomDept);

                // Gán khóa học cho student
                // Ví dụ: mỗi student có 1-5 khóa học ngẫu nhiên
                int numberOfCourses = 1 + rand.nextInt(5);
                Set<CourseEntity> assignedCourses = new HashSet<>();
                for (int j = 0; j < numberOfCourses; j++) {
                    CourseEntity randomCourse = courses.get(rand.nextInt(courses.size()));
                    assignedCourses.add(randomCourse);
                }
                student.getCourses().addAll(assignedCourses);

                students.add(student);
            }
            studentRepo.saveAll(students);
        };
    }

}
