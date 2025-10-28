package com.pluralsight;

import java.util.ArrayList;

// This class represents a car dealership and stores a list of vehicles
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
        this.inventory = new ArrayList<>(); // start with an empty list
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
}
