package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void createCarFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter car make: ");
        String make = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Car car = CarBuilder.carBuilder()
                .setMake(make)
                .setModel(model)
                .setYear(year)
                .build();

        addCar(car);

        System.out.println("Car created and added to the list!");
    }

    public void displayCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Cars in the system:");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a new car");
            System.out.println("2. View all cars");
            System.out.println("3. Exit");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createCarFromUserInput();
                    break;
                case "2":
                    displayCars();
                    break;
                case "3":
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
