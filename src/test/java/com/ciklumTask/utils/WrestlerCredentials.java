package com.ciklumTask.utils;

import com.github.javafaker.Faker;

public enum WrestlerCredentials {
    LAST_NAME(Faker.instance().harryPotter().character()),
    FIRST_NAME(Faker.instance().gameOfThrones().character()),
    DATE_OF_BIRTH(String.valueOf(
                    Faker.instance().number().numberBetween(10, 31)
                    + "-" +
                    Faker.instance().number().numberBetween(10, 12)
                    + "-" +
                    Faker.instance().number().numberBetween(1970, 2018))
    ),
    MIDDLE_NAME(Faker.instance().lordOfTheRings().character()),
    FIRST_REGION(String.valueOf(Faker.instance().number().numberBetween(2, 20))),
    SECOND_REGION(String.valueOf(Faker.instance().number().numberBetween(2, 20))),
    FIRST_FST(String.valueOf(Faker.instance().number().numberBetween(2, 6))),
    SECOND_FST(String.valueOf(Faker.instance().number().numberBetween(2, 6))),
    STYLE(String.valueOf(Faker.instance().number().numberBetween(2, 3))),
    AGE(String.valueOf(Faker.instance().number().numberBetween(2, 3))),
    YEAR(String.valueOf(Faker.instance().number().numberBetween(2013, 2017))),
    LICENCE_TYPE(String.valueOf(Faker.instance().number().numberBetween(2, 3)));

    private String value;

    WrestlerCredentials(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }
