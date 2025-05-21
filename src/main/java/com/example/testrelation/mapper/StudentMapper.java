package com.example.testrelation.mapper;

import com.example.testrelation.dto.StudentDTO;
import com.example.testrelation.entity.StudentEntity;
import com.example.testrelation.mapper.simpleMapper.CourseSimpleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CourseSimpleMapper.class, DepartmentMapper.class})
public interface StudentMapper {
    StudentDTO toDTO(StudentEntity entity);
}