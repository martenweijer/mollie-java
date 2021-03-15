package com.electronics.mollie.resources;

public class Organization {
    private String name;
    private Address address;
    private String registrationNumber;
    private String vatNumber;
    private String vatRegulation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getVatRegulation() {
        return vatRegulation;
    }

    public void setVatRegulation(String vatRegulation) {
        this.vatRegulation = vatRegulation;
    }
}
