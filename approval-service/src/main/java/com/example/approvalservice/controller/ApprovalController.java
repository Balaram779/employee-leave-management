package com.example.approvalservice.controller;

import com.example.approvalservice.model.ApprovalEntity;
import com.example.approvalservice.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalRepository approvalRepository;

    @GetMapping("/{leaveId}")
    public ApprovalEntity getApprovalByLeaveId(@PathVariable String leaveId) {
        return approvalRepository.findByLeaveId(leaveId);
    }
}
