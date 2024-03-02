package org.example.controller;


import org.example.dto.CarDealerShipDTO;
import org.example.service.CarDealerShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarDealerShipController {

    @Autowired
    private CarDealerShipService carDealerShipService;

    @Secured("ROLE_ADMIN")
    @PostMapping({"/dealerShip", "/dealerShip/"})
    public CarDealerShipDTO addDealerShip(@RequestBody  CarDealerShipDTO carDealerShipDTO){
        return carDealerShipService.addCarDealerShip(carDealerShipDTO);
    }

    @GetMapping({"/dealerShip", "/dealerShip/"})
    public List<CarDealerShipDTO> getAllCarDealerShip(){
        return carDealerShipService.getAllCarDealerShip();
    }

    @GetMapping({"/dealerShip/{id}", "/dealerShip/{id}/"})
    public CarDealerShipDTO getCarDealerShip(@PathVariable Long id){
        return carDealerShipService.getCarDealerShip(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping({"/dealerShip/{id}", "/dealerShip/{id}/"})
    public CarDealerShipDTO editCarDealerShip(@RequestBody CarDealerShipDTO carDealerShipDTO, @PathVariable long id){
        return carDealerShipService.editCarDealerShip(carDealerShipDTO, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping({"/dealerShip/{id}", "/dealerShip/{id}/"})
    public CarDealerShipDTO removeCarDealerShip(@PathVariable Long id){
        return carDealerShipService.removeCarDealerShip(id);
    }
}
