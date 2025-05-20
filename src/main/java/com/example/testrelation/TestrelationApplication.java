package com.example.testrelation;

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
            Department it = new Department("IT");
            Department biz = new Department("Business");
            departmentRepo.saveAll(List.of(it, biz));

            Student s1 = new Student("Alice", it);
            Student s2 = new Student("Bob", biz);
            studentRepo.saveAll(List.of(s1, s2));

            Course c1 = new Course("Java");
            Course c2 = new Course("Spring Boot");
            courseRepo.saveAll(List.of(c1, c2));

            // gán khóa học cho sinh viên
            s1.getCourses().addAll(List.of(c1, c2));
            s2.getCourses().add(c1);
            studentRepo.saveAll(List.of(s1, s2));
        };
    }
}
