
package com.example.common.models;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Approval {
    private String approvalId;
    private String leaveId;
    private String status;
    // ✅ Required no-arg constructor
    public Approval() {}
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
	public Approval(String approvalId, String leaveId, String status) {
		super();
		this.approvalId = approvalId;
		this.leaveId = leaveId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", leaveId=" + leaveId + ", status=" + status + "]";
	}
    
    
}
