package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CaravanDTO;
import org.example.dto.mapper.CaravanMapper;
import org.example.entity.CaravanEntity;
import org.example.entity.repository.CaravanRepository;
import org.example.service.CaravanService;
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
public class CaravanServiceIntegrationTest {

    @Autowired
    private CaravanService caravanService;

    @Autowired
    private CaravanRepository caravanRepository;

    @Autowired
    private CaravanMapper caravanMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddCaravan(){
        CaravanDTO caravanDTO = new CaravanDTO();
        caravanDTO.setBrand("Škoda");
        caravanDTO.setModel("Octavia");
        caravanDTO.setKm(135000);
        caravanDTO.setYear(2021);
        caravanDTO.setWeight(1480);

        CaravanDTO addedCaravan = caravanService.addCaravan(caravanDTO);

        assertNotNull(addedCaravan.getId());

        CaravanEntity retrievedCaravan = caravanRepository.findById(addedCaravan.getId()).orElse(null);
        assertNotNull(retrievedCaravan);
        assertEquals(caravanDTO.getBrand(), retrievedCaravan.getBrand());
        assertEquals(caravanDTO.getModel(), retrievedCaravan.getModel());
        assertEquals(caravanDTO.getYear(), retrievedCaravan.getYear());
        assertEquals(caravanDTO.getWeight(), retrievedCaravan.getWeight());
        assertEquals(caravanDTO.getKm(), retrievedCaravan.getKm());
    }

    @Test
    public void testGetAllCaravans() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/caravan"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetCaravan()throws Exception{
        Long caravanId = 1L;

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/caravan/" + caravanId))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testEditCaravan() throws Exception {
        Long caravanId = 1L;

        CaravanDTO caravanDTO = new CaravanDTO();
        caravanDTO.setBrand("VW");
        caravanDTO.setModel("Passat");
        caravanDTO.setWeight(1950);
        caravanDTO.setKm(13500);
        caravanDTO.setAvailable(true);
        caravanDTO.setYear(2023);

        when(caravanRepository.existsById(eq(caravanId))).thenReturn(true);

        CaravanEntity entity = new CaravanEntity();
        when(caravanRepository.getReferenceById(eq(caravanId))).thenReturn(entity);

        CaravanEntity savedEntity = new CaravanEntity();
        when(caravanRepository.save(any())).thenReturn(savedEntity);

        mockMvc.perform(post("/api/caravan/{id}", caravanId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(caravanDTO)))
                .andExpect(status().isOk());

        verify(caravanRepository).existsById(caravanId);
        verify(caravanRepository).getReferenceById(caravanId);
        verify(caravanRepository).save(entity);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveCaravan() throws Exception {
        Long caravanId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/caravan/{id}", caravanId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(caravanService, times(1)).removeCaravan(caravanId);
    }
}

