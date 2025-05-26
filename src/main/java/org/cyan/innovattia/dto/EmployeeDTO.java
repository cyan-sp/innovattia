package org.cyan.innovattia.dto;

import java.util.List;

public class EmployeeDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String curp;
    private String position;
    private String immediateBossId;
    private AddressDTO address;
    private List<EmployeeDTO> subordinates; // Add this line

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EmployeeDTO> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDTO> subordinates) {
        this.subordinates = subordinates;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateBossId() {
        return immediateBossId;
    }

    public void setImmediateBossId(String immediateBossId) {
        this.immediateBossId = immediateBossId;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
