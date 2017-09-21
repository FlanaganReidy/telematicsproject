package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VehicleInfo vehicle = new VehicleInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Vin: (int)");
        vehicle.set_VIN(Integer.parseInt(scanner.next()));
        System.out.println("Enter Odometer Mileage: (double)");
        vehicle.setOdometer(Double.parseDouble(scanner.next()));
        System.out.println("Enter gallons of gas consumed: (double)");
        vehicle.setConsumption(Double.parseDouble(scanner.next()));
        System.out.println("Enter mileage at last oil change: (double)");
        vehicle.setOdometerAtLastOilChange(Double.parseDouble(scanner.next()));
        System.out.println("Enter engine size in liters: (double)");
        vehicle.setEngineSizeInLiters(Double.parseDouble(scanner.next()));

        try {
            TelematicsService.report(vehicle);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TelematicsService.allFilesToInstances();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
