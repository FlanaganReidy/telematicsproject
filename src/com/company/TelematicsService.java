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
}
