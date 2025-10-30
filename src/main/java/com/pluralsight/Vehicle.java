package com.pluralsight;

// Vehicle class holds all details about a single vehicle
public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int odometer;
    private double price;

    // constructor
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

    // getters
    public int getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public String getColor() { return color; }
    public int getOdometer() { return odometer; }
    public double getPrice() { return price; }

    // setters
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return vin + " | " + year + " | " + make + " | " + model + " | " + type +
                " | " + color + " | " + odometer + " miles | $" + price;
    }
}
