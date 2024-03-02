package org.example.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.dto.CarDealerShipDTO;
import org.example.dto.mapper.CarDealerShipMapper;
import org.example.entity.CarDealerShipEntity;
import org.example.entity.repository.CarDealerShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDealerShipServiceImpl implements CarDealerShipService{

    @Autowired
    private CarDealerShipMapper carDealerShipMapper;

    @Autowired
    private CarDealerShipRepository carDealerShipRepository;


    @Override
    public CarDealerShipDTO addCarDealerShip(CarDealerShipDTO carDealerShipDTO) {
        CarDealerShipEntity dealerShip = carDealerShipMapper.toEntity(carDealerShipDTO);
        CarDealerShipEntity save = carDealerShipRepository.save(dealerShip);
        return carDealerShipMapper.toDTO(save);
    }

    @Override
    public List <CarDealerShipDTO> getAllCarDealerShip() {
        List<CarDealerShipDTO> dealerShip = new ArrayList<>();
        for(CarDealerShipEntity carDealerShip : carDealerShipRepository.findAll()){
            dealerShip.add(carDealerShipMapper.toDTO(carDealerShip));
        }
        return dealerShip;
    }

    @Override
    public CarDealerShipDTO getCarDealerShip(long id) {
        CarDealerShipEntity carDealerShip = carDealerShipRepository.getReferenceById(id);
            return carDealerShipMapper.toDTO(carDealerShip);
    }

    @Override
    public CarDealerShipDTO editCarDealerShip(CarDealerShipDTO carDealerShipDTO, long id) {
        if (!carDealerShipRepository.existsById(id)){
            throw new EntityNotFoundException("Car dealer ship with id " + id + " wasn't found in the database.");
        }
        CarDealerShipEntity entity = carDealerShipMapper.toEntity(carDealerShipDTO);
        entity.setId(id);
        CarDealerShipEntity saved = carDealerShipRepository.save(entity);
        return carDealerShipMapper.toDTO(saved);
    }

    @Override
    public CarDealerShipDTO removeCarDealerShip(Long id) {
        CarDealerShipEntity entity = carDealerShipRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        CarDealerShipDTO model = carDealerShipMapper.toDTO(entity);
        carDealerShipRepository.delete(entity);
        return model;
    }
}
