package org.example.service;


import org.example.dto.CaravanDTO;
import org.example.entity.filter.CaravanFilter;

import java.util.List;

public interface CaravanService {

    CaravanDTO addCaravan(CaravanDTO caravanDTO);

    List<CaravanDTO> getAllCaravans(CaravanFilter caravanFilter);

    CaravanDTO getCaravan(long id);

    CaravanDTO editCaravan(CaravanDTO caravanDTO, long id);

    CaravanDTO removeCaravan(long id);


}
