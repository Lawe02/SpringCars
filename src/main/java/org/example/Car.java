package org.example;

import java.util.UUID;

public class Car {
    private UUID carId;
    private String make;
    private String model;
    private int year;

    public Car(String Make, String Model, int Year) {
        carId = UUID.randomUUID();
        this.make = Make;
        this.model = Model;
        this.year = Year;
    }
    @Override
    public String toString(){
        return "Make: "+this.make+" Model: "+this.model+" Year: "+this.year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }
}
