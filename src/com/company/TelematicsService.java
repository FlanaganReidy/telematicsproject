package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicsService {
    static void report(VehicleInfo vehicleInfo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(vehicleInfo._VIN+".json");
        FileWriter fileWriter = new FileWriter(file);
        String json = mapper.writeValueAsString(vehicleInfo);
        fileWriter.write(json);
        fileWriter.close();


    }
    static void allFilesToInstances() throws IOException {
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo car = mapper.readValue(new File(String.valueOf(f)), VehicleInfo.class);
                System.out.println(car);

            }
        }

    }
}
