package com.example.approvalservice.repository;

import com.example.approvalservice.model.ApprovalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<ApprovalEntity, String> {
    ApprovalEntity findByLeaveId(String leaveId);
}
