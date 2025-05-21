package com.example.testrelation.mapper;

import com.example.testrelation.dto.StudentDTO;
import com.example.testrelation.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CourseMapper.class}) // để Spring quản lý bean
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "department", target = "department")
    @Mapping(source = "courses", target = "courses")
    StudentDTO toDTO(StudentEntity student);
}
