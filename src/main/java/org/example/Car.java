package org.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
}
