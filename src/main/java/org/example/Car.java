package org.example;

import java.util.UUID;

public class Car {
    private UUID carId;
    private String make;
    private String model;
    private int year;

    public Car(String Make, String Model, int Year) {
        carId = UUID.randomUUID();
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
