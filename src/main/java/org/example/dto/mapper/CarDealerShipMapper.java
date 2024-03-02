package org.example.dto.mapper;


import org.example.dto.CarDealerShipDTO;
import org.example.entity.CarDealerShipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDealerShipMapper {

    CarDealerShipDTO toDTO(CarDealerShipEntity source);

    CarDealerShipEntity toEntity(CarDealerShipDTO source);

}
