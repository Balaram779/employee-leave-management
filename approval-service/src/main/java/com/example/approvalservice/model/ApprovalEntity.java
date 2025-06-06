package com.example.approvalservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ApprovalEntity {

    @Id
    private String approvalId;
    private String leaveId;
    private String status;

    public ApprovalEntity() {}

    public ApprovalEntity(String approvalId, String leaveId, String status) {
        this.approvalId = approvalId;
        this.leaveId = leaveId;
        this.status = status;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
