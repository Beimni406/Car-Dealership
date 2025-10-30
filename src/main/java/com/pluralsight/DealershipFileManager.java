package com.pluralsight;

import java.io.*;
import java.util.Scanner;

// Handles reading and writing dealership data from a file
public class DealershipFileManager {

    public Dealership getDealership() {
        try {
            File file = new File("dealership.csv"); // your file name
            Scanner scanner = new Scanner(file);

            // read first line for dealership info
            String[] dealerInfo = scanner.nextLine().split("\\|");
            Dealership dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);

            // read remaining lines for vehicles
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("\\|");
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            scanner.close();
            return dealership;

        } catch (Exception e) {
            System.out.println("Error loading dealership file: " + e.getMessage());
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            PrintWriter writer = new PrintWriter("dealership.csv");
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving dealership: " + e.getMessage());
        }
    }
}
