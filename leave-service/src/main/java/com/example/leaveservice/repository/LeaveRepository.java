
package com.example.leaveservice.repository;

import com.example.leaveservice.model.LeaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequestEntity, String> {
    List<LeaveRequestEntity> findByEmployeeId(String employeeId);
}
