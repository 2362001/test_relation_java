package com.example.testrelation.mapper.simpleMapper;

import com.example.testrelation.dto.simpleDTO.CourseSimpleDTO;
import com.example.testrelation.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseSimpleMapper {
    @Mapping(source = "title", target = "name")
    CourseSimpleDTO toDTO(CourseEntity entity);
}