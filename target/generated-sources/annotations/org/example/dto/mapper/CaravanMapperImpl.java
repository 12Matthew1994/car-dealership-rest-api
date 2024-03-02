package org.example.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.example.dto.CaravanDTO;
import org.example.entity.CaravanEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Amazon.com Inc.)"
)
@Component
public class CaravanMapperImpl implements CaravanMapper {

    @Override
    public CaravanDTO toDTO(CaravanEntity source) {
        if ( source == null ) {
            return null;
        }

        CaravanDTO caravanDTO = new CaravanDTO();

        if ( source.getId() != null ) {
            caravanDTO.setId( source.getId() );
        }
        caravanDTO.setBrand( source.getBrand() );
        caravanDTO.setModel( source.getModel() );
        caravanDTO.setYear( source.getYear() );
        caravanDTO.setWeight( source.getWeight() );
        caravanDTO.setKm( source.getKm() );
        caravanDTO.setAvailable( source.isAvailable() );
        if ( source.getDateAdded() != null ) {
            caravanDTO.setDateAdded( new SimpleDateFormat().format( source.getDateAdded() ) );
        }

        return caravanDTO;
    }

    @Override
    public CaravanEntity toEntity(CaravanDTO source) {
        if ( source == null ) {
            return null;
        }

        CaravanEntity caravanEntity = new CaravanEntity();

        caravanEntity.setId( source.getId() );
        caravanEntity.setBrand( source.getBrand() );
        caravanEntity.setModel( source.getModel() );
        caravanEntity.setYear( source.getYear() );
        caravanEntity.setWeight( source.getWeight() );
        caravanEntity.setKm( source.getKm() );
        caravanEntity.setAvailable( source.isAvailable() );
        try {
            if ( source.getDateAdded() != null ) {
                caravanEntity.setDateAdded( new SimpleDateFormat().parse( source.getDateAdded() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return caravanEntity;
    }
}
