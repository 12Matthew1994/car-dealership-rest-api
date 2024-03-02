package org.example.dto.mapper;

import javax.annotation.processing.Generated;
import org.example.dto.CarDealerShipDTO;
import org.example.entity.CarDealerShipEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Amazon.com Inc.)"
)
@Component
public class CarDealerShipMapperImpl implements CarDealerShipMapper {

    @Override
    public CarDealerShipDTO toDTO(CarDealerShipEntity source) {
        if ( source == null ) {
            return null;
        }

        CarDealerShipDTO carDealerShipDTO = new CarDealerShipDTO();

        carDealerShipDTO.setId( source.getId() );
        carDealerShipDTO.setCity( source.getCity() );
        carDealerShipDTO.setZipCode( source.getZipCode() );
        carDealerShipDTO.setStreet( source.getStreet() );
        carDealerShipDTO.setNumber( source.getNumber() );

        return carDealerShipDTO;
    }

    @Override
    public CarDealerShipEntity toEntity(CarDealerShipDTO source) {
        if ( source == null ) {
            return null;
        }

        CarDealerShipEntity carDealerShipEntity = new CarDealerShipEntity();

        carDealerShipEntity.setId( source.getId() );
        carDealerShipEntity.setCity( source.getCity() );
        carDealerShipEntity.setZipCode( source.getZipCode() );
        carDealerShipEntity.setStreet( source.getStreet() );
        carDealerShipEntity.setNumber( source.getNumber() );

        return carDealerShipEntity;
    }
}
