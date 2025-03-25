package com.lutetia.lutetiawebshop.dto;

import com.lutetia.lutetiawebshop.models.Address;

public class RegistrationDTO {
    public String email;
    public String password;
    public String firstName;
    public String middleName;
    public String lastName;
    public String phoneNumber;
    public Address address;

    public RegistrationDTO(String email, String password, String firstName, String middleName, String lastName, String phoneNumber, Address address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}