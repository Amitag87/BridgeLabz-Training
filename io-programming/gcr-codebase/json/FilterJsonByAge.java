package json;

import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FilterJsonByAge {

    // Inner class (POJO)
    static class User {
        int id;
        String name;
        int age;
    }

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();

            // Read JSON file and convert to List<User>
            FileReader reader = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\users.json");
            List<User> users = gson.fromJson(
                    reader,
                    new TypeToken<List<User>>() {}.getType()
            );

            // Filter and print users older than 25
            System.out.println("Users older than 25:");

            for (User user : users) {
                if (user.age > 25) {
                    System.out.println(
                            "Id: " + user.id +
                            ", Name: " + user.name +
                            ", Age: " + user.age
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

