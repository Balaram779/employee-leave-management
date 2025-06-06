
package com.example.employeeservice.controller;

import com.example.employeeservice.model.EmployeeEntity;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public EmployeeEntity create(@RequestBody EmployeeEntity employee) {
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity update(@PathVariable String id, @RequestBody EmployeeEntity updated) {
        updated.setEmployeeId(id);
        return repository.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
