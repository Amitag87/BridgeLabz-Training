package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CsvToJsonConverter {

    public static void main(String[] args) {

        String csvFile = "C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\data.csv";
        List<Map<String, String>> jsonList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            String[] headers = null;

            // Read first line (headers)
            if ((line = br.readLine()) != null) {
                headers = line.split(",");
            }

            // Read remaining lines (data)
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> jsonMap = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    jsonMap.put(headers[i], values[i]);
                }
                jsonList.add(jsonMap);
            }

            // Convert List to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(jsonList);

            System.out.println("JSON Output:");
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
