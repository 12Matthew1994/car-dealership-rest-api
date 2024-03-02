package org.example.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.dto.CaravanDTO;
import org.example.dto.mapper.CaravanMapper;
import org.example.entity.CaravanEntity;
import org.example.entity.filter.CaravanFilter;
import org.example.entity.repository.CaravanRepository;
import org.example.entity.repository.specification.CaravanSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaravanServiceImpl implements CaravanService{

    @Autowired
    private CaravanRepository caravanRepository;

    @Autowired
    private CaravanMapper caravanMapper;


    @Override
    public CaravanDTO addCaravan(CaravanDTO caravanDTO) {
        CaravanEntity caravan = caravanMapper.toEntity(caravanDTO);
        CaravanEntity save = caravanRepository.save(caravan);
        return caravanMapper.toDTO(save);
    }

    @Override
    public List<CaravanDTO> getAllCaravans(CaravanFilter caravanFilter) {
        CaravanSpecification caravanSpecification = new CaravanSpecification(caravanFilter);
        List<CaravanDTO> caravans = new ArrayList<>();
        Page<CaravanEntity> caravanPage = caravanRepository.findAll(caravanSpecification, PageRequest.of(0, caravanFilter.getLimit()));
        for(CaravanEntity caravan : caravanPage.getContent()){
            caravans.add(caravanMapper.toDTO(caravan));
        }
        return caravans;
    }

    @Override
    public CaravanDTO getCaravan(long id) {
        CaravanEntity caravan = caravanRepository.getReferenceById(id);
        return caravanMapper.toDTO(caravan);
    }

    @Override
    public CaravanDTO editCaravan(CaravanDTO caravanDTO, long id) {
        if(!caravanRepository.existsById(id)){
            throw new EntityNotFoundException("Car with id " + id + "don´t exist in the database");
        }
        CaravanEntity entity = caravanRepository.getReferenceById(id);
        entity.setId(id);
        CaravanEntity saved = caravanRepository.save(entity);
        return caravanMapper.toDTO(saved);
    }

    @Override
    public CaravanDTO removeCaravan(long id) {
        CaravanEntity caravan = caravanRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        CaravanDTO model = caravanMapper.toDTO(caravan);
        caravanRepository.delete(caravan);
        return model;
    }
}
