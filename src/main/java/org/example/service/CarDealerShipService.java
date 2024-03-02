package org.example.service;


import org.example.dto.CarDealerShipDTO;

import java.util.List;

public interface CarDealerShipService {

    CarDealerShipDTO addCarDealerShip(CarDealerShipDTO carDealerShipDTO);
    List<CarDealerShipDTO> getAllCarDealerShip();

    CarDealerShipDTO getCarDealerShip(long id);

    CarDealerShipDTO editCarDealerShip (CarDealerShipDTO carDealerShipDTO, long id);

    CarDealerShipDTO removeCarDealerShip(Long id);








}
