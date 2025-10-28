package com.pluralsight;

import java.io.*;

// This class handles reading and saving dealership data from a CSV file
public class DealershipFileManager {

    // Reads the dealership.csv file and returns a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));
            String dealershipInfo = reader.readLine(); // first line = dealership info
            String[] parts = dealershipInfo.split("\\|");

            // first line creates the dealership
            dealership = new Dealership(parts[0], parts[1], parts[2]);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

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

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }
}
