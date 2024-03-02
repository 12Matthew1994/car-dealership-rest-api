package org.example.dto.mapper;


import org.example.dto.MotorbikeDTO;
import org.example.entity.MotorbikeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotorbikeMapper {

    MotorbikeDTO toDTO(MotorbikeEntity source);

    MotorbikeEntity toEntity(MotorbikeDTO source);
}
