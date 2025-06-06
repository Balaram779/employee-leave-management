package com.example.leaveservice.kafka;

import com.example.common.models.Approval;
import com.example.leaveservice.model.LeaveRequestEntity;
import com.example.leaveservice.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ApprovalEventConsumer {

    @Autowired
    private LeaveRepository leaveRepository;

    @KafkaListener(topics = "approval-events-v2", groupId = "leave-service-group")
    public void consumeApproval(Approval approval) {
        System.out.println("✅ Received approval event: " + approval);

        LeaveRequestEntity entity = leaveRepository.findById(approval.getLeaveId()).orElse(null);
        if (entity != null) {
            entity.setStatus(approval.getStatus());
            leaveRepository.save(entity);
            System.out.println("✅ Leave status updated for ID: " + approval.getLeaveId());
        } else {
            System.out.println("⚠️ Leave ID not found: " + approval.getLeaveId());
        }
    }
}
