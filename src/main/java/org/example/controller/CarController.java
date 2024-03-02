package org.example.controller;


import org.example.dto.CarDTO;
import org.example.entity.filter.CarFilter;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @Secured("ROLE_ADMIN")
    @PostMapping({"/car", "/car/"})
    public CarDTO addCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO);
    }

    @GetMapping({"/car", "/car/"})
    public List<CarDTO> getAllCars(CarFilter carFilter){
        return carService.getAllCars(carFilter);
    }

    @GetMapping({"/car/{id}", "/car/{id}/"})
    public CarDTO getCar(@PathVariable Long id){
        return carService.getCar(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping({"/car/{id}", "/car/{id}/"})
    public CarDTO editCar(@RequestBody CarDTO carDTO, @PathVariable Long id){
        return carService.editCar(carDTO, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping({"/car/{id}", "/car/{id}/"})
    public CarDTO removeCar(@PathVariable Long id){
        return carService.removeCar(id);
    }
}

