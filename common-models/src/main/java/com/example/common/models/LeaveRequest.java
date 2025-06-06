
package com.example.common.models;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class LeaveRequest {
    private String leaveId;
    private String employeeId;
    private String startDate;
    private String endDate;
    private String status;
    
    // ✅ Required no-arg constructor
    public LeaveRequest() {}
    
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LeaveRequest(String leaveId, String employeeId, String startDate, String endDate, String status) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeaveRequest [leaveId=" + leaveId + ", employeeId=" + employeeId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + "]";
	}
    
    
}
