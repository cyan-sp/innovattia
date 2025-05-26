package org.cyan.innovattia.repository;

import org.cyan.innovattia.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
