package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

// UserInterface handles user menu and commands
public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        init();
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 99);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        System.out.println("Loaded dealership: " + dealership.getName());
    }

    private void displayMenu() {
        System.out.println("\n--- " + dealership.getName() + " ---");
        System.out.println("1 - Find vehicles by price range");
        System.out.println("2 - Find vehicles by make and model");
        System.out.println("3 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter your choice: ");
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {
        System.out.println("Enter vehicle info to add:");
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("Vehicle added!");
    }

    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        Vehicle toRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                toRemove = v;
                break;
            }
        }
        if (toRemove != null) {
            dealership.removeVehicle(toRemove);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
