package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.MotorbikeDTO;
import org.example.dto.mapper.MotorbikeMapper;
import org.example.entity.MotorbikeEntity;
import org.example.entity.repository.MotorbikeRepository;
import org.example.service.MotorbikeService;
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
public class MotorbikeServiceIntegrationTest {

    @Autowired
    private MotorbikeService motorbikeService;

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    @Autowired
    private MotorbikeMapper motorbikeMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddMotorbike(){
        MotorbikeDTO motorbikeDTO = new MotorbikeDTO();
        motorbikeDTO.setBrand("Yamaha");
        motorbikeDTO.setModel("R1");
        motorbikeDTO.setKm(1350);
        motorbikeDTO.setYear(2021);
        motorbikeDTO.setWeight(250);

        MotorbikeDTO addedMotorbike = motorbikeService.addMotorbike(motorbikeDTO);

        assertNotNull(addedMotorbike.getId());

        MotorbikeEntity retrievedMotorbike = motorbikeRepository.findById(addedMotorbike.getId()).orElse(null);
        assertNotNull(retrievedMotorbike);
        assertEquals(motorbikeDTO.getBrand(), retrievedMotorbike.getBrand());
        assertEquals(motorbikeDTO.getModel(), retrievedMotorbike.getModel());
        assertEquals(motorbikeDTO.getYear(), retrievedMotorbike.getYear());
        assertEquals(motorbikeDTO.getWeight(), retrievedMotorbike.getWeight());
        assertEquals(motorbikeDTO.getKm(), retrievedMotorbike.getKm());
    }

    @Test
    public void testGetAllMotorbikes() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/motorbike"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetMotorbike()throws Exception{
        Long motorbikeId = 1L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/motorbike/" + motorbikeId))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testEditMotorbike() throws Exception {
        Long motorbikeId = 1L;

        MotorbikeDTO motorbikeDTO = new MotorbikeDTO();
        motorbikeDTO.setBrand("Yamaha");
        motorbikeDTO.setModel("R1");
        motorbikeDTO.setWeight(250);
        motorbikeDTO.setKm(1350);
        motorbikeDTO.setAvailable(true);
        motorbikeDTO.setYear(2023);

        when(motorbikeRepository.existsById(eq(motorbikeId))).thenReturn(true);

        MotorbikeEntity entity = new MotorbikeEntity();
        when(motorbikeRepository.getReferenceById(eq(motorbikeId))).thenReturn(entity);

        MotorbikeEntity savedEntity = new MotorbikeEntity();
        when(motorbikeRepository.save(any())).thenReturn(savedEntity);

        mockMvc.perform(post("/api/motorbike/{id}", motorbikeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(motorbikeDTO)))
                .andExpect(status().isOk());

        verify(motorbikeRepository).existsById(motorbikeId);
        verify(motorbikeRepository).getReferenceById(motorbikeId);
        verify(motorbikeRepository).save(entity);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveMotorbike() throws Exception {
        Long motorbikeId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/motorbike/{id}", motorbikeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(motorbikeService, times(1)).removeMotorbike(motorbikeId);
    }
}

