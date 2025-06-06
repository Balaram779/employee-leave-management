package com.example.employeeservice.controller;

import com.example.employeeservice.model.EmployeeEntity;
import com.example.employeeservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void testCreateEmployee() throws Exception {
        Mockito.when(employeeRepository.save(any())).thenReturn(
                new EmployeeEntity("EMP001", "Balaram", "IT", "Engineer"));

        String requestBody = """
        {
          "employeeId": "EMP001",
          "name": "Balaram",
          "department": "IT",
          "designation": "Engineer"
        }
        """;

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value("EMP001"))
                .andExpect(jsonPath("$.name").value("Balaram"));
    }
}