package com.pluralsight;

import java.util.ArrayList;

// Dealership holds info about the dealership and all its vehicles
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    // add a new vehicle
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // remove a vehicle
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    // get all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // find vehicles by price range
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                results.add(v);
            }
        }
        return results;
    }

    // find vehicles by make and model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                results.add(v);
            }
        }
        return results;
    }

    // find vehicles by year range
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                results.add(v);
            }
        }
        return results;
    }

    // find vehicles by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                results.add(v);
            }
        }
        return results;
    }

    // find vehicles by mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                results.add(v);
            }
        }
        return results;
    }

    // find vehicles by type
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getType().equalsIgnoreCase(type)) {
                results.add(v);
            }
        }
        return results;
    }
}
