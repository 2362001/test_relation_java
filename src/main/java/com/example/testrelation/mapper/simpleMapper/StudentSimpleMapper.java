package com.example.testrelation.mapper.simpleMapper;

import com.example.testrelation.dto.simpleDTO.StudentSimpleDTO;
import com.example.testrelation.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentSimpleMapper {
    StudentSimpleDTO toDTO(StudentEntity entity);
}