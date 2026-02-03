package json;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class IPLAndCensorAnalyzer {

    // -------- CENSOR RULES --------
    private static String maskTeamName(String team) {
        int idx = team.indexOf(" ");
        return (idx != -1) ? team.substring(0, idx) + " ***" : team;
    }

    private static String redactPlayer() {
        return "REDACTED";
    }

    // -------- JSON PROCESSING --------
    public static void processJson(String input, String output) throws Exception {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Map<String, Object>> matches =
                gson.fromJson(new FileReader(input),
                        new TypeToken<List<Map<String, Object>>>() {}.getType());

        for (Map<String, Object> match : matches) {

            match.put("team1", maskTeamName(match.get("team1").toString()));
            match.put("team2", maskTeamName(match.get("team2").toString()));
            match.put("winner", maskTeamName(match.get("winner").toString()));
            match.put("player_of_match", redactPlayer());

            // Update score keys
            Map<String, Object> score =
                    (Map<String, Object>) match.get("score");

            Map<String, Object> newScore = new LinkedHashMap<>();
            for (String key : score.keySet()) {
                newScore.put(maskTeamName(key), score.get(key));
            }
            match.put("score", newScore);
        }

        FileWriter writer = new FileWriter(output);
        gson.toJson(matches, writer);
        writer.close();
    }

    // -------- CSV PROCESSING --------
    public static void processCsv(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        FileWriter fw = new FileWriter(output);

        String header = br.readLine();
        fw.write(header + "\n");

        String line;
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            data[1] = maskTeamName(data[1]); // team1
            data[2] = maskTeamName(data[2]); // team2
            data[5] = maskTeamName(data[5]); // winner
            data[6] = redactPlayer();        // player_of_match

            fw.write(String.join(",", data) + "\n");
        }

        br.close();
        fw.close();
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        try {
            processJson("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\ipl_data.json", "ipl_censored.json");
            processCsv("C:\\Users\\DELL\\eclipse-workspace\\BridgeLabzTraining_Duplicate\\src\\JSONdata\\src\\main\\java\\json\\ipl_data.csv", "ipl_censored.csv");

            System.out.println("✅ IPL data censored successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
