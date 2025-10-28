package com.pluralsight;

import java.io.*;

// This class handles reading and saving dealership data from a CSV file
public class DealershipFileManager {

    // Reads dealership info and vehicles from the CSV file
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));
            String dealershipInfo = reader.readLine();
            String[] parts = dealershipInfo.split("\\|");

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

    // Saves dealership and all vehicles back into dealership.csv
    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle v : dealership.getAllVehicles()) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                        v.getType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
