
package com.example.leaveservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LeaveRequestEntity {
    @Id
    private String leaveId;
    private String employeeId;
    private String startDate;
    private String endDate;
    private String status;

    public LeaveRequestEntity() {}

    public LeaveRequestEntity(String leaveId, String employeeId, String startDate, String endDate, String status) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getLeaveId() { return leaveId; }
    public void setLeaveId(String leaveId) { this.leaveId = leaveId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
