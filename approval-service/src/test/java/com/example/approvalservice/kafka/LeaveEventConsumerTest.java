package com.example.approvalservice.kafka;

import com.example.approvalservice.model.ApprovalEntity;
import com.example.approvalservice.repository.ApprovalRepository;
import com.example.common.models.LeaveRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LeaveEventConsumerTest {

    private ApprovalRepository approvalRepository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private LeaveEventConsumer leaveEventConsumer;

    @BeforeEach
    public void setup() {
        approvalRepository = mock(ApprovalRepository.class);
        kafkaTemplate = mock(KafkaTemplate.class);
        leaveEventConsumer = new LeaveEventConsumer(approvalRepository, kafkaTemplate);
    }

    @Test
    public void testApprovalDecisionApproved() {
        LeaveRequest request = new LeaveRequest(
                UUID.randomUUID().toString(), "EMP001", "2025-06-10", "2025-06-12", "PENDING"
        );

        leaveEventConsumer.consumeLeaveRequest(request);

        ArgumentCaptor<ApprovalEntity> captor = ArgumentCaptor.forClass(ApprovalEntity.class);
        verify(approvalRepository, times(1)).save(captor.capture());
        verify(kafkaTemplate, times(1)).send(eq("approval-events-v2"), any());

        ApprovalEntity saved = captor.getValue();
        assertEquals(request.getLeaveId(), saved.getLeaveId());
        assertEquals("APPROVED", saved.getStatus());
        assertNotNull(saved.getApprovalId());
    }
}
