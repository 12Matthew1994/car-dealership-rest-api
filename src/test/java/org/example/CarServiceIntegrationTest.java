package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CarDTO;
import org.example.dto.mapper.CaravanMapper;
import org.example.entity.CarEntity;
import org.example.entity.repository.CarRepository;
import org.example.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarServiceIntegrationTest {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CaravanMapper caravanMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddCar(){
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand("Škoda");
        carDTO.setModel("Octavia");
        carDTO.setKm(135000);
        carDTO.setYear(2021);
        carDTO.setWeight(1480);

        CarDTO addedCar = carService.addCar(carDTO);

        assertNotNull(addedCar.getId());

        CarEntity retrievedCar = carRepository.findById(addedCar.getId()).orElse(null);
        assertNotNull(retrievedCar);
        assertEquals(carDTO.getBrand(), retrievedCar.getBrand());
        assertEquals(carDTO.getModel(), retrievedCar.getModel());
        assertEquals(carDTO.getYear(), retrievedCar.getYear());
        assertEquals(carDTO.getWeight(), retrievedCar.getWeight());
        assertEquals(carDTO.getKm(), retrievedCar.getKm());
    }

    @Test
    public void testGetAllCars() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/car"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetCar()throws Exception{
        Long carId = 1L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/car/" + carId))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testEditCar() throws Exception {
        Long carId = 1L;

        CarDTO carDTO = new CarDTO();
        carDTO.setBrand("VW");
        carDTO.setModel("Passat");
        carDTO.setWeight(1950);
        carDTO.setKm(13500);
        carDTO.setAvailable(true);
        carDTO.setYear(2023);

        when(carRepository.existsById(eq(carId))).thenReturn(true);

        CarEntity entity = new CarEntity();
        when(carRepository.getReferenceById(eq(carId))).thenReturn(entity);

        CarEntity savedEntity = new CarEntity();
        when(carRepository.save(any())).thenReturn(savedEntity);

        mockMvc.perform(post("/api/car/{id}", carId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carDTO)))
                .andExpect(status().isOk());

        verify(carRepository).existsById(carId);
        verify(carRepository).getReferenceById(carId);
        verify(carRepository).save(entity);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveCar() throws Exception {
        Long carId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/car/{id}", carId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(carService, times(1)).removeCar(carId);
    }
}
