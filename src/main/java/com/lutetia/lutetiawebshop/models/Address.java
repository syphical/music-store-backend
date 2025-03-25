package com.lutetia.lutetiawebshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    // Constructors
    public Address() {
    }

    public Address(String streetAddress, String houseNumber, String zipCode, String city, String province) {
        this.streetAddress = streetAddress;
        this.houseNumber = houseNumber;
        this.zipcode = zipCode;
        this.city = city;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}