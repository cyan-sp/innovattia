package org.cyan.innovattia.mapper;

import org.cyan.innovattia.dto.EmployeeDTO;
import org.cyan.innovattia.dto.AddressDTO;
import org.cyan.innovattia.model.Employee;
import org.cyan.innovattia.model.Address;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setCurp(employee.getCurp());
        dto.setPosition(employee.getPosition());
        dto.setImmediateBossId(employee.getImmediateBossId());
        dto.setAddress(toAddressDTO(employee.getAddress()));
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setCurp(dto.getCurp());
        employee.setPosition(dto.getPosition());
        employee.setImmediateBossId(dto.getImmediateBossId());
        employee.setAddress(toAddress(dto.getAddress()));
        return employee;
    }

    private AddressDTO toAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setExteriorNumber(address.getExteriorNumber());
        addressDTO.setInteriorNumber(address.getInteriorNumber());
        addressDTO.setNeighborhood(address.getNeighborhood());
        addressDTO.setMunicipality(address.getMunicipality());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    private Address toAddress(AddressDTO dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setExteriorNumber(dto.getExteriorNumber());
        address.setInteriorNumber(dto.getInteriorNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setMunicipality(dto.getMunicipality());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        return address;
    }
}
