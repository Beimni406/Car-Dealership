package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

// The UserInterface class provides a simple text menu
// that allows users to view and interact with dealership data.
public class UserInterface {
    private DealershipFileManager fileManager;
    private Dealership dealership;
    private Scanner scanner;

    // Constructor: sets up scanner and file manager
    public UserInterface() {
        fileManager = new DealershipFileManager();
        scanner = new Scanner(System.in);
    }

    // Starts the program
    public void display() {
        dealership = fileManager.getDealership();

        if (dealership == null) {
            System.out.println("Error loading dealership. Check dealership.csv file.");
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
                    running = false;
                    fileManager.saveDealership(dealership);
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    // Display all vehicles
    private void displayAllVehicles() {
        System.out.println("\n--- All Vehicles ---");
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
        System.out.println("--------------------");
    }

    // Search by price range
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
    }

    // Search by make/model
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

    // Program entry point
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.display();
    }
}
