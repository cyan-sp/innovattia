package org.cyan.innovattia.service;

import org.cyan.innovattia.dto.EmployeeDTO;
import org.cyan.innovattia.mapper.EmployeeMapper;
import org.cyan.innovattia.model.Employee;
import org.cyan.innovattia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employee.setId(generateUniqueId(employee.getCurp()));
        employeeRepository.save(employee);
        return employeeMapper.toDTO(employee);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employee);
        return employeeMapper.toDTO(employee);
    }

    public EmployeeDTO updateEmployeePartial(String id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (employeeDTO.getFirstName() != null) {
            existingEmployee.setFirstName(employeeDTO.getFirstName());
        }
        if (employeeDTO.getLastName() != null) {
            existingEmployee.setLastName(employeeDTO.getLastName());
        }
        if (employeeDTO.getPosition() != null) {
            existingEmployee.setPosition(employeeDTO.getPosition());
        }
        if (employeeDTO.getImmediateBossId() != null) {
            existingEmployee.setImmediateBossId(employeeDTO.getImmediateBossId());
        }
        if (employeeDTO.getAddress() != null) {
            if (employeeDTO.getAddress().getStreet() != null) {
                existingEmployee.getAddress().setStreet(employeeDTO.getAddress().getStreet());
            }
            if (employeeDTO.getAddress().getExteriorNumber() != null) {
                existingEmployee.getAddress().setExteriorNumber(employeeDTO.getAddress().getExteriorNumber());
            }
            if (employeeDTO.getAddress().getInteriorNumber() != null) {
                existingEmployee.getAddress().setInteriorNumber(employeeDTO.getAddress().getInteriorNumber());
            }
            if (employeeDTO.getAddress().getNeighborhood() != null) {
                existingEmployee.getAddress().setNeighborhood(employeeDTO.getAddress().getNeighborhood());
            }
            if (employeeDTO.getAddress().getMunicipality() != null) {
                existingEmployee.getAddress().setMunicipality(employeeDTO.getAddress().getMunicipality());
            }
            if (employeeDTO.getAddress().getState() != null) {
                existingEmployee.getAddress().setState(employeeDTO.getAddress().getState());
            }
            if (employeeDTO.getAddress().getCountry() != null) {
                existingEmployee.getAddress().setCountry(employeeDTO.getAddress().getCountry());
            }
        }

        employeeRepository.save(existingEmployee);
        return employeeMapper.toDTO(existingEmployee);
    }

    public List<EmployeeDTO> listEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    private String generateUniqueId(String curp) {
        return curp.substring(0, 10) + (int)(Math.random() * 90 + 10);
    }
}
