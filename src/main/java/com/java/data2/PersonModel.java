package com.java.data2;
/**
 * Describes Person Model
 */
public class PersonModel {

    private String lastName;
    private String firstName;
    private String birthYear;
    private String city;
    private String street;
    private String house;
    private String apartment;

    public PersonModel(String lastName, String firstName, String birthYear, String city,
                       String street, String house, String apartment) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthYear = birthYear;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }
}
