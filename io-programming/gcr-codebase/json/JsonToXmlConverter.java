package json;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {

    public static void main(String[] args) {

        // JSON input as String
        String jsonString = "{"
                + "\"student\": {"
                + "  \"id\": 1,"
                + "  \"name\": \"Chaman\","
                + "  \"age\": 22,"
                + "  \"email\": \"chaman@gmail.com\""
                + "}"
                + "}";

        try {
            // Convert JSON String to JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Convert JSONObject to XML
            String xml = XML.toString(jsonObject);

            System.out.println("XML Output:");
            System.out.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
