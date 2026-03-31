import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSVSalary {
    public static void main(String[] args) {

        String inputFile = "data.csv";
        String outputFile = "updated_employees.csv";
        String line;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {

            // Write header
            writer.write(br.readLine() + "\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());

                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10; // 10% increment
                }

                writer.write(
                    data[0] + "," +
                    data[1] + "," +
                    department + "," +
                    (int) salary + "\n"
                );
            }

            System.out.println("Updated CSV file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
