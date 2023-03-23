package com.serenitydojo.webchallenge.domain;

import java.util.Random;

public class Shopper {
    private String email;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String county;
    private String phoneNumber;

    public static Shopper standardShopper() {
        return new Shopper();
    }

    public Shopper() {
        Random random = new Random();
        email = "user_" + random.nextInt() + "@acme.com";
        firstName = "Joe";
        lastName = "User";
        streetAddress = "1 Main Street";
        city = "Exeter";
        county = "United Kingdom";
        phoneNumber = "0712345678";
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
