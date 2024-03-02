package org.example.service;


import org.example.dto.MotorbikeDTO;
import org.example.entity.filter.MotorbikeFilter;

import java.util.List;

public interface MotorbikeService {

    MotorbikeDTO addMotorbike(MotorbikeDTO motorbikeDTO);

    List<MotorbikeDTO> getAllMotorbikes(MotorbikeFilter motorbikeFilter);

    MotorbikeDTO getMotorbike(long id);

    MotorbikeDTO editMotorbike(MotorbikeDTO motorbikeDTO, long id);

    MotorbikeDTO removeMotorbike(long id);
}
