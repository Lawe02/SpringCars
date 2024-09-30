package org.example;

public class CarBuilder {

    private int year;
    private String make;
    private String model;

    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Car build() {
        Car car = new Car(make,model,year);
        return car;
    }
}
