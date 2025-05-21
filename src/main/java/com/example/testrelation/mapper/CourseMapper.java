package com.example.testrelation.mapper;

import com.example.testrelation.dto.CourseDTO;
import com.example.testrelation.entity.CourseEntity;
import com.example.testrelation.mapper.simpleMapper.StudentSimpleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

    @Mapper(componentModel = "spring", uses = {StudentSimpleMapper.class})
    public interface CourseMapper {
        @Mapping(source = "title", target = "name")
    //    @Mapping(target = "students", ignore = true)
            // <- thêm dòng này để không ánh xạ students
        CourseDTO toDTO(CourseEntity entity);
    }