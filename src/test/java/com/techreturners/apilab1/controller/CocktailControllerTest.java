package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CocktailControllerTest {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCocktailNow() throws Exception {

        String expectedContent = "I need a cocktail now!";

        this.mockMvcController.perform(
                 MockMvcRequestBuilders.get("/cocktailnow"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeWithoutRequestParams() throws Exception {

        String expectedContent = "manhattan";

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/cocktail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

    @Test
    public void testGetCoffeeWithRequestParams() throws Exception {

        String expectedContent = "longislandicedtea";

        this.mockMvcController.perform(
                 MockMvcRequestBuilders.get("/cocktail").param("name","longislandicedtea"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

}

