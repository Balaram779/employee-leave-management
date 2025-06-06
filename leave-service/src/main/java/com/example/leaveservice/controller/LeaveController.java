
package com.example.leaveservice.controller;

import com.example.common.models.LeaveRequest;
import com.example.leaveservice.kafka.LeaveEventProducer;
import com.example.leaveservice.model.LeaveRequestEntity;
import com.example.leaveservice.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveRepository repository;

    @Autowired
    private LeaveEventProducer producer;

    @PostMapping
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        request.setLeaveId(UUID.randomUUID().toString());
        request.setStatus("PENDING");
        LeaveRequestEntity entity = new LeaveRequestEntity(
                request.getLeaveId(), request.getEmployeeId(),
                request.getStartDate(), request.getEndDate(), request.getStatus()
        );
        repository.save(entity);
        producer.sendLeaveEvent(request);
        return request;
    }

    @GetMapping("/{id}")
    public Optional<LeaveRequestEntity> getLeaveById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping
    public List<LeaveRequestEntity> getLeavesByEmployee(@RequestParam String employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @PutMapping("/{id}/status")
    public LeaveRequestEntity updateStatus(@PathVariable String id, @RequestParam String status) {
        LeaveRequestEntity entity = repository.findById(id).orElseThrow();
        entity.setStatus(status);
        return repository.save(entity);
    }
}
