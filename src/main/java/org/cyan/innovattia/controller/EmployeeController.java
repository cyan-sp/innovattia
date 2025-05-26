package org.cyan.innovattia.controller;

import org.cyan.innovattia.dto.EmployeeDTO;
import org.cyan.innovattia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.registerEmployee(employeeDTO));
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeePartial(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployeePartial(id, employeeDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> listEmployees() {
        return ResponseEntity.ok(employeeService.listEmployees());
    }
}
