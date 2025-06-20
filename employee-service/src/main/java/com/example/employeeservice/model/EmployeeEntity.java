
package com.example.employeeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {
    @Id
    private String employeeId;
    private String name;
    private String department;
    private String designation;

    public EmployeeEntity() {}

    public EmployeeEntity(String employeeId, String name, String department, String designation) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}
