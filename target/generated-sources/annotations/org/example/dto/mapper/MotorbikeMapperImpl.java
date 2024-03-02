package org.example.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.example.dto.MotorbikeDTO;
import org.example.entity.MotorbikeEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Amazon.com Inc.)"
)
@Component
public class MotorbikeMapperImpl implements MotorbikeMapper {

    @Override
    public MotorbikeDTO toDTO(MotorbikeEntity source) {
        if ( source == null ) {
            return null;
        }

        MotorbikeDTO motorbikeDTO = new MotorbikeDTO();

        if ( source.getId() != null ) {
            motorbikeDTO.setId( source.getId() );
        }
        motorbikeDTO.setBrand( source.getBrand() );
        motorbikeDTO.setModel( source.getModel() );
        motorbikeDTO.setYear( source.getYear() );
        motorbikeDTO.setWeight( source.getWeight() );
        motorbikeDTO.setKm( source.getKm() );
        motorbikeDTO.setAvailable( source.isAvailable() );
        if ( source.getDateAdded() != null ) {
            motorbikeDTO.setDateAdded( new SimpleDateFormat().format( source.getDateAdded() ) );
        }

        return motorbikeDTO;
    }

    @Override
    public MotorbikeEntity toEntity(MotorbikeDTO source) {
        if ( source == null ) {
            return null;
        }

        MotorbikeEntity motorbikeEntity = new MotorbikeEntity();

        motorbikeEntity.setId( source.getId() );
        motorbikeEntity.setBrand( source.getBrand() );
        motorbikeEntity.setModel( source.getModel() );
        motorbikeEntity.setYear( source.getYear() );
        motorbikeEntity.setWeight( source.getWeight() );
        motorbikeEntity.setKm( source.getKm() );
        motorbikeEntity.setAvailable( source.isAvailable() );
        try {
            if ( source.getDateAdded() != null ) {
                motorbikeEntity.setDateAdded( new SimpleDateFormat().parse( source.getDateAdded() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return motorbikeEntity;
    }
}
