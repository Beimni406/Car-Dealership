package com.pluralsight;

import java.io.*;

// The DealershipFileManager class is responsible for
// reading data from dealership.csv and saving updates back to the file.
public class DealershipFileManager {

    // Loads dealership info and vehicles from the CSV file
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"))) {

            // Read the first line: dealership info
            String dealershipInfo = reader.readLine();
            if (dealershipInfo == null) {
                System.out.println("Error: dealership.csv file is empty!");
                return null;
            }

            // Split the first line into name, address, and phone
            String[] parts = dealershipInfo.split("\\|");
            dealership = new Dealership(parts[0], parts[1], parts[2]);

            // Read the rest of the lines: each one is a Vehicle
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

        } catch (IOException e) {
            System.out.println("Error reading dealership.csv: " + e.getMessage());
        }

        return dealership;
    }

    // Saves dealership info and vehicles back into dealership.csv
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"))) {

            // Write dealership info (first line)
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            // Write all vehicle data (following lines)
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }

            System.out.println("Dealership data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving dealership.csv: " + e.getMessage());
        }
    }
}
