package org.example.controller;


import org.example.dto.CaravanDTO;
import org.example.entity.filter.CaravanFilter;
import org.example.service.CaravanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CaravanController {

    @Autowired
    private CaravanService caravanService;

    @Secured("ROLE_ADMIN")
    @PostMapping({"/caravan", "/caravan/"})
    public CaravanDTO addCaravan(CaravanDTO caravanDTO){
        return caravanService.addCaravan(caravanDTO);
    }

    @GetMapping({"/caravan", "/caravan/"})
    public List<CaravanDTO> getAllCaravans(CaravanFilter caravanFilter){
        return caravanService.getAllCaravans(caravanFilter);
    }

    @GetMapping({"/caravan/{id}", "/caravan/{id}/"})
    public CaravanDTO getCaravan(@PathVariable Long id){
        return caravanService.getCaravan(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping({"/caravan/{id}", "/caravan/{id}/"})
    public CaravanDTO editCaravan(@RequestBody CaravanDTO caravanDTO, @PathVariable Long id){
        return caravanService.editCaravan(caravanDTO, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping({"/caravan/{id}", "/caravan/{id}/"})
    public CaravanDTO removeCaravan(@PathVariable Long id){
        return caravanService.removeCaravan(id);
    }
}
