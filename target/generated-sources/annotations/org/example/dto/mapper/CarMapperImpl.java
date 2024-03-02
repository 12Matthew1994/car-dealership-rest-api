package org.example.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.example.dto.CarDTO;
import org.example.entity.CarEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Amazon.com Inc.)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO toDTO(CarEntity source) {
        if ( source == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        if ( source.getId() != null ) {
            carDTO.setId( source.getId() );
        }
        carDTO.setBrand( source.getBrand() );
        carDTO.setModel( source.getModel() );
        carDTO.setYear( source.getYear() );
        carDTO.setWeight( source.getWeight() );
        carDTO.setKm( source.getKm() );
        carDTO.setAvailable( source.isAvailable() );
        if ( source.getDateAdded() != null ) {
            carDTO.setDateAdded( new SimpleDateFormat().format( source.getDateAdded() ) );
        }

        return carDTO;
    }

    @Override
    public CarEntity toEntity(CarDTO source) {
        if ( source == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setId( source.getId() );
        carEntity.setBrand( source.getBrand() );
        carEntity.setModel( source.getModel() );
        carEntity.setYear( source.getYear() );
        carEntity.setWeight( source.getWeight() );
        carEntity.setKm( source.getKm() );
        carEntity.setAvailable( source.isAvailable() );
        try {
            if ( source.getDateAdded() != null ) {
                carEntity.setDateAdded( new SimpleDateFormat().parse( source.getDateAdded() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return carEntity;
    }
}
