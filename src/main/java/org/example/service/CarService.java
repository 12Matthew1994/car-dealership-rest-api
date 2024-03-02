package org.example.service;


import org.example.dto.CarDTO;
import org.example.entity.filter.CarFilter;

import java.util.List;

public interface CarService {

    CarDTO addCar(CarDTO carDTO);

    List<CarDTO> getAllCars(CarFilter carFilter);

    CarDTO getCar(long id);

    CarDTO editCar(CarDTO carDTO, long id);

    CarDTO removeCar(long id);
}
