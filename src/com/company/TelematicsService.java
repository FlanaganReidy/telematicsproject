package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelematicsService {
    static void report(VehicleInfo vehicleInfo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(vehicleInfo._VIN+".json");
        FileWriter fileWriter = new FileWriter(file);
        String json = mapper.writeValueAsString(vehicleInfo);
        fileWriter.write(json);
        fileWriter.close();


    }
    static ArrayList allFilesToInstances() throws IOException {
        File file = new File(".");
        ArrayList<VehicleInfo> allVehicles = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo car = mapper.readValue(new File(String.valueOf(f)), VehicleInfo.class);
                allVehicles.add(car);
                System.out.println(car);


            }
        }
        return allVehicles;

    }
    static boolean updateHtmlfile(ArrayList<VehicleInfo> allVehicles){
        String rowTemplate = "";
        for(VehicleInfo vehicle:allVehicles ){
            rowTemplate += "<tr>"+"<td>" + vehicle.get_VIN() + "</td>"
                    + "<td>" + vehicle.getOdometer() + "</td>"
                    + "<td>" + vehicle.getConsumption() + "</td>"
                    + "<td>" + vehicle.getOdometerAtLastOilChange() + "</td>"
                    + "<td>" + vehicle.getEngineSizeInLiters() + "</td>"+ "</tr>";
        }


        File file = new File("./src/dashboard.html");
        try {
            Scanner fileScanner = new Scanner(file);
            String fileContents = "";
            while (fileScanner.hasNext()) {
                fileContents += fileScanner.nextLine();
            }

            System.out.println(rowTemplate);
            //update with new vehicles
            String updatedFile = fileContents.replaceAll("marker", rowTemplate);
            //set arraylist size
            updatedFile = updatedFile.replaceAll("arraylistsize", Integer.toString(allVehicles.size()));
            //set average odometer
            float sum = 0;
            for(VehicleInfo vehicle:allVehicles ){
                sum += vehicle.getOdometer();
            }
            float average = sum/allVehicles.size();
            String avg = String.format("%.1f", average);
            updatedFile = updatedFile.replaceAll("averageodometer", avg);
            //average consumption
            sum = 0;
            for(VehicleInfo vehicle:allVehicles ){
                sum += vehicle.getConsumption();
            }
            average = sum/allVehicles.size();
            avg = String.format("%.1f", average);
            updatedFile = updatedFile.replaceAll("averageconsumption", avg);
            //average oilchange
            sum = 0;
            for(VehicleInfo vehicle:allVehicles ){
                sum += vehicle.getOdometerAtLastOilChange();
            }
            average = sum/allVehicles.size();
            avg = String.format("%.1f", average);
            updatedFile = updatedFile.replaceAll("averagelastoilchange", avg);
            //enginesizeinleters
            sum = 0;
            for(VehicleInfo vehicle:allVehicles ){
                sum += vehicle.getEngineSizeInLiters();
            }
            average = sum/allVehicles.size();
            avg = String.format("%.1f", average);
            updatedFile = updatedFile.replaceAll("averageenginesize", avg);

            ObjectMapper mapper = new ObjectMapper();
            File secondFile = new File("./src/dashTemplate.html");
            FileWriter fileWriter = new FileWriter(secondFile);
            fileWriter.write(updatedFile);
            fileWriter.close();
        } //Since this time we are asking for data back from the file
        //We have to specify what to do if it isn't found
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file *" + "dashboard.html" + "*");
            ex.printStackTrace();
            return false;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
