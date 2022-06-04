package com.springwook.jpa_01_hello.jpa02;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    String city;
    String street;
    String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Address() {

    }
}
