package com.ciklumTask.utils;

import com.github.javafaker.Faker;

public class WrestlerFlexibleCredentials {
    private Faker faker = new Faker();
    private String lastName = faker.harryPotter().character();
    private String firstName = faker.harryPotter().character();
    private String dateObBirth = String.valueOf(
                    faker.number().numberBetween(10, 31)
                    + "-" +
                    faker.number().numberBetween(10, 12)
                    + "-" +
                    faker.number().numberBetween(1970, 2018));
    private String middleName = faker.harryPotter().character();
    private String firstRegion = String.valueOf(faker.number().numberBetween(2, 20));
    private String secondRegion = String.valueOf(faker.number().numberBetween(2, 20));
    private String firstFST = String.valueOf(faker.number().numberBetween(2, 6));
    private String secondFST = String.valueOf(faker.number().numberBetween(2, 6));
    private String style = String.valueOf(faker.number().numberBetween(2, 3));
    private String age = String.valueOf(faker.number().numberBetween(2, 3));
    private String year = String.valueOf(faker.number().numberBetween(2013, 2017));
    private String licence = String.valueOf(faker.number().numberBetween(2, 3));

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateObBirth() {
        return dateObBirth;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstRegion() {
        return firstRegion;
    }

    public String getSecondRegion() {
        return secondRegion;
    }

    public String getFirstFST() {
        return firstFST;
    }

    public String getSecondFST() {
        return secondFST;
    }

    public String getStyle() {
        return style;
    }

    public String getAge() {
        return age;
    }

    public String getYear() {
        return year;
    }

    public String getLicence() {
        return licence;
    }
}
