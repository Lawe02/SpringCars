package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CarManager {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarsByModelName(String model) {
        return cars.stream().filter(car -> car.getModel().contains(model)).toList();
    }

    public List<Car> getCarsSortedByYear() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .toList();
    }

    public List<Car> getCarsByMakeName(String make) {
        return cars.stream().filter(car -> car.getMake().contains(make)).toList();
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


    public void displayCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Cars in the system:");
            for (Car car : cars) {
                System.out.println(car.toString());
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
            System.out.println("3. Get cars by model");
            System.out.println("4. Get cars by make");
            System.out.println("5. Sort cars by year");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createCarFromUserInput();
                    break;
                case "2":
                    displayCars(cars);
                    break;
                case "3":
                    System.out.print("Enter the model of the car you want to search for: ");
                    String model = scanner.nextLine();
                    List<Car> carsByModel = getCarsByModelName(model);
                    displayCars(carsByModel);
                    break;
                case "4":
                    System.out.print("Enter the make of the car you want to search for: ");
                    String make = scanner.nextLine();
                    List<Car> carsByMake = getCarsByMakeName(make);
                    displayCars(carsByMake);
                    break;
                case "5":
                    System.out.print("Cars sorted by year: ");
                    List<Car> carsbyYear = getCarsSortedByYear();
                    displayCars(carsbyYear);
                    break;
                case "6":
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
