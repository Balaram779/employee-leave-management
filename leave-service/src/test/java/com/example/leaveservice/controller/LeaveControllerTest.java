
package com.example.leaveservice.controller;

import com.example.leaveservice.kafka.LeaveEventProducer;
import com.example.leaveservice.model.LeaveRequestEntity;
import com.example.leaveservice.repository.LeaveRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LeaveController.class)
public class LeaveControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeaveRepository leaveRepository;

    @MockBean
    private LeaveEventProducer leaveEventProducer;

    @Test
    void testApplyLeave() throws Exception {
        Mockito.when(leaveRepository.save(any())).thenReturn(
                new LeaveRequestEntity("LEAVE123", "EMP001", "2025-06-10", "2025-06-12", "PENDING")
        );

        String requestBody = """
        {
          "employeeId": "EMP001",
          "startDate": "2025-06-10",
          "endDate": "2025-06-12"
        }
        """;

        mockMvc.perform(post("/leaves")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value("EMP001"))
                .andExpect(jsonPath("$.status").value("PENDING"));
    }
}
