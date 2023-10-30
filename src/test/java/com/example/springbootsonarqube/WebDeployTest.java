package com.example.springbootsonarqube;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
@WebMvcTest(WebDeployController.class)
class WebDeployControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndex() throws Exception {

        var result =  mockMvc.perform(MockMvcRequestBuilders
                .get("/api/deploy")
                .accept(MediaType.APPLICATION_JSON));

        //Then
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.message").value("Web deploy ok"))
                .andExpect(jsonPath("$.date").isNotEmpty());
    }

}