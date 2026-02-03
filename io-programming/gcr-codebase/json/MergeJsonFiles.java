package json;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MergeJsonFiles {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();

            // Read first JSON file
            JsonObject json1 = gson.fromJson(
                    new FileReader("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\file1.json"),
                    JsonObject.class
            );

            // Read second JSON file
            JsonObject json2 = gson.fromJson(
                    new FileReader("fC:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\file2.json"),
                    JsonObject.class
            );

            // Merge json2 into json1
            for (String key : json2.keySet()) {
                json1.add(key, json2.get(key));
            }

            // Print merged JSON
            System.out.println("Merged JSON:");
            System.out.println(gson.toJson(json1));

            // (Optional) Write merged JSON to file
            FileWriter writer = new FileWriter("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\merged.json");
            gson.toJson(json1, writer);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
