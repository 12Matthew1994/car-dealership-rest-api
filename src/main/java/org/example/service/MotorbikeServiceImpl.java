package org.example.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.dto.MotorbikeDTO;
import org.example.dto.mapper.MotorbikeMapper;
import org.example.entity.MotorbikeEntity;
import org.example.entity.filter.MotorbikeFilter;
import org.example.entity.repository.MotorbikeRepository;
import org.example.entity.repository.specification.MotorbikeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotorbikeServiceImpl implements MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    @Autowired
    MotorbikeMapper motorbikeMapper;

    @Override
    public MotorbikeDTO addMotorbike(MotorbikeDTO motorbikeDTO) {
        MotorbikeEntity entity = motorbikeMapper.toEntity(motorbikeDTO);
        MotorbikeEntity saved = motorbikeRepository.save(entity);
        return motorbikeMapper.toDTO(saved);
    }

    @Override
    public List<MotorbikeDTO> getAllMotorbikes(MotorbikeFilter motorbikeFilter) {
        MotorbikeSpecification motorbikeSpecification = new MotorbikeSpecification(motorbikeFilter);
        List<MotorbikeDTO> motorbikes = new ArrayList<>();
        Page<MotorbikeEntity> motorbikePage = motorbikeRepository.findAll(motorbikeSpecification, PageRequest.of(0, motorbikeFilter.getLimit()));
        for(MotorbikeEntity motorbike : motorbikePage.getContent()){
            motorbikes.add(motorbikeMapper.toDTO(motorbike));
        }
        return motorbikes;
    }

    @Override
    public MotorbikeDTO getMotorbike(long id) {
        MotorbikeEntity entity = motorbikeRepository.getReferenceById(id);
        return motorbikeMapper.toDTO(entity);
    }

    @Override
    public MotorbikeDTO editMotorbike(MotorbikeDTO motorbikeDTO, long id) {
        if(!motorbikeRepository.existsById(id)){
            throw new EntityNotFoundException("Motorbike with id" + id + "don´t exist in the database");
        }
        MotorbikeEntity entity = motorbikeMapper.toEntity(motorbikeDTO);
        entity.setId(id);
        MotorbikeEntity saved = motorbikeRepository.save(entity);
        return motorbikeMapper.toDTO(saved);
    }

    @Override
    public MotorbikeDTO removeMotorbike(long id) {
        MotorbikeEntity entity = motorbikeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        MotorbikeDTO model = motorbikeMapper.toDTO(entity);
        motorbikeRepository.delete(entity);
        return model;
    }
}
