
package com.example.leaveservice.kafka;

import com.example.common.models.LeaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LeaveEventProducer {
    private static final String TOPIC = "leave-events";

    @Autowired
    private KafkaTemplate<String, LeaveRequest> kafkaTemplate;

    public void sendLeaveEvent(LeaveRequest request) {
        kafkaTemplate.send(TOPIC, request);
    }
}
