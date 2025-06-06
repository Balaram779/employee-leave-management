
package com.example.approvalservice.kafka;

import com.example.approvalservice.model.ApprovalEntity;
import com.example.approvalservice.repository.ApprovalRepository;
import com.example.common.models.Approval;
import com.example.common.models.LeaveRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.UUID;
@Component
public class LeaveEventConsumer {

    private final ApprovalRepository approvalRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public LeaveEventConsumer(ApprovalRepository approvalRepository,
                              KafkaTemplate<String, Object> kafkaTemplate) {
        this.approvalRepository = approvalRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "leave-events", groupId = "approval-group")
    public void consumeLeaveRequest(LeaveRequest request) {
        System.out.println("Received Leave Request: " + request);
        int days = Integer.parseInt(request.getEndDate().substring(8)) -
                   Integer.parseInt(request.getStartDate().substring(8)) + 1;
        String status = days <= 3 ? "APPROVED" : "REJECTED";

        ApprovalEntity approval = new ApprovalEntity(
                UUID.randomUUID().toString(),
                request.getLeaveId(),
                status
        );
        approvalRepository.save(approval);

        Approval approvalEvent = new Approval(
            approval.getApprovalId(),
            approval.getLeaveId(),
            approval.getStatus()
        );

        kafkaTemplate.send("approval-events-v2", approvalEvent);

    }
}


