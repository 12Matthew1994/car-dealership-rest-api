package org.example.dto.mapper;


import org.example.dto.CarDTO;
import org.example.entity.CarEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO toDTO(CarEntity source);

    CarEntity toEntity(CarDTO source);
}
