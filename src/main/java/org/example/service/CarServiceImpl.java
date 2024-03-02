package org.example.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.dto.CarDTO;
import org.example.dto.mapper.CarMapper;
import org.example.entity.CarEntity;
import org.example.entity.filter.CarFilter;
import org.example.entity.repository.CarRepository;
import org.example.entity.repository.specification.CarSpecification;
import org.example.entity.repository.specification.CaravanSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CarRepository carRepository;


    @Override
    public CarDTO addCar(CarDTO carDTO) {
        CarEntity car = carMapper.toEntity(carDTO);
        CarEntity save = carRepository.save(car);
        return carMapper.toDTO(save);
    }

    @Override
    public List<CarDTO> getAllCars(CarFilter carFilter) {
        CarSpecification carSpecification = new CarSpecification(carFilter);
        List<CarDTO> cars = new ArrayList<>();
        Page<CarEntity> carPage = carRepository.findAll(carSpecification, PageRequest.of(0, carFilter.getLimit()));
        for(CarEntity car : carPage.getContent()){
            cars.add(carMapper.toDTO(car));
        }
        return cars;
    }

    @Override
    public CarDTO getCar(long id) {
        CarEntity entity = carRepository.getReferenceById(id);
        return carMapper.toDTO(entity);
    }

    @Override
    public CarDTO editCar(CarDTO carDTO, long id) {
        if(!carRepository.existsById(id)){
            throw new EntityNotFoundException("Car with id " + id + "don´t exist in the database");
        }
        CarEntity entity = carMapper.toEntity(carDTO);
        entity.setId(id);
        CarEntity saved = carRepository.save(entity);
        return carMapper.toDTO(saved);
    }

    @Override
    public CarDTO removeCar(long id) {
        CarEntity entity = carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        CarDTO model = carMapper.toDTO(entity);
        carRepository.delete(entity);
        return model;
    }
}
