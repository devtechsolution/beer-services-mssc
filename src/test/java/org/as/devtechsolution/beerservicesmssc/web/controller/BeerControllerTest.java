package org.as.devtechsolution.beerservicesmssc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.as.devtechsolution.beerservicesmssc.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getBeerById ( ) throws Exception {
        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer ( ) throws Exception {
        BeerDto beerDto= BeerDto.builder().build();
        String beerToJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerToJson))
                .andExpect(status().isOk());
    }

    @Test
    void updateBeerById ( ) throws Exception {
        BeerDto beerDto= BeerDto.builder().build();
        String beerToJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isOk());
    }
}