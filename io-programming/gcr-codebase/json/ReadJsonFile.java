package json;

import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadJsonFile {

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\data.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);

            printJson(jsonObject, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printJson(Object obj, String indent) {

        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                System.out.println(indent + key + " :");
                printJson(value, indent + "  ");
            }

        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;

            for (int i = 0; i < jsonArray.length(); i++) {
                printJson(jsonArray.get(i), indent + "  ");
            }

        } else {
            System.out.println(indent + obj);
        }
    }
}

