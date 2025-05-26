package org.cyan.innovattia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String curp;
    private String position;
    private String immediateBossId;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "immediateBossId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> subordinates; // Define the relationship

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
