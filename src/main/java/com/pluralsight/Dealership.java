package com.pluralsight;

import java.util.ArrayList;

// The Dealership class stores information about the dealership
// and manages a list of Vehicle objects
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor for Dealership
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Getter methods
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // Add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Return all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Search methods (placeholders for now)
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) { return null; }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) { return null; }
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) { return null; }
    public ArrayList<Vehicle> getVehiclesByColor(String color) { return null; }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) { return null; }
    public ArrayList<Vehicle> getVehiclesByType(String type) { return null; }

    // Empty remove method for now
    public void removeVehicle(Vehicle vehicle) {
        // to be implemented later
    }
}
