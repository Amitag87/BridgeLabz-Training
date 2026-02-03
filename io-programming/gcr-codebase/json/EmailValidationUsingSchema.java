package json;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class EmailValidationUsingSchema {

    public static void main(String[] args) {

        // JSON Schema with email validation
        String schemaStr = "{"
                + "  \"type\": \"object\","
                + "  \"properties\": {"
                + "    \"email\": {"
                + "      \"type\": \"string\","
                + "      \"format\": \"email\""
                + "    }"
                + "  },"
                + "  \"required\": [\"email\"]"
                + "}";

        // JSON data to validate
        String jsonData = "{ \"email\": \"testuser@gmail.com\" }";
        // Try invalid email:
        // String jsonData = "{ \"email\": \"testusergmail.com\" }";

        try {
            // Load schema
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStr));
            Schema schema = SchemaLoader.load(rawSchema);

            // Validate JSON
            JSONObject jsonObject = new JSONObject(jsonData);
            schema.validate(jsonObject);

            System.out.println("✅ Email is valid according to JSON Schema");

        } catch (Exception e) {
            System.out.println("❌ Invalid email format");
            System.out.println(e.getMessage());
        }
    }
}
