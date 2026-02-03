package json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DatabaseToJsonReport {

    public static void main(String[] args) {

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        List<Map<String, Object>> reportData = new ArrayList<>();

        try {
            // Load MySQL driver
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Execute query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            // Process result set
            while (rs.next()) {
                Map<String, Object> record = new HashMap<>();
                record.put("id", rs.getInt("id"));
                record.put("name", rs.getString("name"));
                record.put("department", rs.getString("department"));
                record.put("salary", rs.getDouble("salary"));
                reportData.add(record);
            }

            // Close DB resources
            rs.close();
            stmt.close();
            con.close();

            // Convert to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonReport = gson.toJson(reportData);

            // Print JSON report
            System.out.println("JSON Report:");
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
