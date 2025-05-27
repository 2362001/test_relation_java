package com.example.testrelation.mapper;

import com.example.testrelation.dto.DepartmentDTO;
import com.example.testrelation.entity.DepartmentEntity;
import com.example.testrelation.mapper.simpleMapper.StudentSimpleMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {StudentSimpleMapper.class}) // để Spring quản lý bean
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDTO toDTO(DepartmentEntity department);
}
