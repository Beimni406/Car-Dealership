package com.pluralsight;

// The Vehicle class represents a single vehicle in the dealership system.
// It stores basic vehicle details like VIN, year, make, model, type, color, odometer, and price.
public class Vehicle {

    // Fields (attributes)
    private int vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int odometer;
    private double price;

    // Constructor: initializes a Vehicle object with all its details
    public Vehicle(int vin, int year, String make, String model, String type, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getter methods (to access private variables)
    public int getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public String getColor() { return color; }
    public int getOdometer() { return odometer; }
    public double getPrice() { return price; }

    // Setter methods (optional, if needed to update data later)
    public void setVin(int vin) { this.vin = vin; }
    public void setYear(int year) { this.year = year; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setType(String type) { this.type = type; }
    public void setColor(String color) { this.color = color; }
    public void setOdometer(int odometer) { this.odometer = odometer; }
    public void setPrice(double price) { this.price = price; }

    // toString method for easy display of vehicle info
    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + color + ") - $" + price;
    }
}
