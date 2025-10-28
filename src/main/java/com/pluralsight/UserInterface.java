package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

// The UserInterface class provides a simple menu-driven interface
// for interacting with the dealership and its vehicles.
public class UserInterface {
    private DealershipFileManager fileManager;
    private Dealership dealership;
    private Scanner scanner;

    // Constructor: initializes the file manager and input scanner
    public UserInterface() {
        fileManager = new DealershipFileManager();
        scanner = new Scanner(System.in);
    }

    // Main menu display and program loop
    public void display() {
        dealership = fileManager.getDealership();

        if (dealership == null) {
            System.out.println("Error: Could not load dealership. Check your dealership.csv file.");
            return;
        }

        System.out.println("Welcome to " + dealership.getName() + "!");
        boolean running = true;

        while (running) {
            System.out.println("\n========== Dealership Menu ==========");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Search by Price Range");
            System.out.println("3. Search by Make/Model");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    searchByPrice();
                    break;
                case 3:
                    searchByMakeModel();
                    break;
                case 4:
                    fileManager.saveDealership(dealership);
                    System.out.println("Goodbye! Data saved successfully.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Display all vehicles in inventory
    private void displayAllVehicles() {
        System.out.println("\n--- All Vehicles ---");
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println("--------------------");
    }

    // Search vehicles by price range
    private void searchByPrice() {
        System.out.print("Enter minimum price: ");
        double min = getDoubleInput();
        System.out.print("Enter maximum price: ");
        double max = getDoubleInput();

        System.out.println("\n--- Vehicles between $" + min + " and $" + max + " ---");
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle v : vehicles) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                System.out.println(v);
            }
        }
        System.out.println("--------------------");
    }

    // Search vehicles by make and model
    private void searchByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Enter model: ");
        String model = scanner.nextLine().trim();

        System.out.println("\n--- Results for " + make + " " + model + " ---");
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle v : vehicles) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
            }
        }
        System.out.println("--------------------");
    }

    // Helper method for safe integer input
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }

    // Helper method for safe double input
    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }

    // Entry point to run the program
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.display();
    }
}
