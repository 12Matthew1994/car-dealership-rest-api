package org.example.controller;


import org.example.dto.MotorbikeDTO;
import org.example.entity.filter.MotorbikeFilter;
import org.example.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @Secured("ROLE_ADMIN")
    @PostMapping({"/motorbike", "/motorbike/"})
    public MotorbikeDTO addMotorbike(@RequestBody MotorbikeDTO motorbikeDTO){
        return motorbikeService.addMotorbike(motorbikeDTO);
    }

    @GetMapping({"/motorbike", "/motorbike/"})
    public List<MotorbikeDTO> getAllMotorbikes(MotorbikeFilter motorbikeFilter){
        return motorbikeService.getAllMotorbikes(motorbikeFilter);
    }

    @GetMapping({"/motorbike/{id}", "/motorbike/{id}/"})
    public MotorbikeDTO getMotorbike(@PathVariable Long id){
        return motorbikeService.getMotorbike(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping({"/motorbike/{id}", "/motorbike/{id}/"})
    public MotorbikeDTO editMotorbike(@RequestBody MotorbikeDTO motorbikeDTO, @PathVariable Long id){
        return motorbikeService.editMotorbike(motorbikeDTO, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping({"/motorbike/{id}", "/motorbike/{id}/"})
    public MotorbikeDTO removeMotorbike(@PathVariable Long id){
        return motorbikeService.removeMotorbike(id);
    }
}
