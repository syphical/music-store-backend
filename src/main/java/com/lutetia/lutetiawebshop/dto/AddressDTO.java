package com.lutetia.lutetiawebshop.dto;

public class AddressDTO {
    public String street;
    public String houseNumber;
    public String zipCode;
    public String city;
    public String province;

    public AddressDTO(String street, String houseNumber, String zipCode, String city, String province) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.province = province;
    }
}