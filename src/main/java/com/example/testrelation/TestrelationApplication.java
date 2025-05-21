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

import java.util.List;

@SpringBootApplication
public class TestrelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestrelationApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(DepartmentRepository departmentRepo, StudentRepository studentRepo, CourseRepository courseRepo) {
        return args -> {
            DepartmentEntity it = new DepartmentEntity("IT");
            DepartmentEntity biz = new DepartmentEntity("Business");
            departmentRepo.saveAll(List.of(it, biz));

            StudentEntity s1 = new StudentEntity("Alice", it);
            StudentEntity s2 = new StudentEntity("Bob", biz);
            studentRepo.saveAll(List.of(s1, s2));

            CourseEntity c1 = new CourseEntity("Java");
            CourseEntity c2 = new CourseEntity("Spring Boot");
            courseRepo.saveAll(List.of(c1, c2));

            // gán khóa học cho sinh viên
            s1.getCourses().addAll(List.of(c1, c2));
            s2.getCourses().add(c1);
            studentRepo.saveAll(List.of(s1, s2));
        };
    }
}
