package org.example.dto.mapper;

import org.example.dto.CaravanDTO;
import org.example.entity.CaravanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CaravanMapper {

    CaravanDTO toDTO(CaravanEntity source);

    CaravanEntity toEntity(CaravanDTO source);
}
