package com.example.testrelation.mapper;

import com.example.testrelation.dto.CourseDTO;
import com.example.testrelation.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // để Spring quản lý bean
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    @Mapping(source = "title", target = "name")
    CourseDTO toDTO(CourseEntity course);
}
