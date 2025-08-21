package org.flipfit.core;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User{
    private String name;
    private String phoneNumber;

    public Admin(String email, String password, String roleId, String name, String phoneNumber) {
        super(email, password, roleId);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Admin() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
