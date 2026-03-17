import java.util.*;

public class VersionStorage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, Integer>> fileMap = new HashMap<>();
        Map<String, String> latestVersion = new HashMap<>();

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");
            String op = input[0];

            switch (op) {

                case "UPLOAD":
                    String file = input[1];
                    String version = input[2];
                    int size = Integer.parseInt(input[3]);

                    fileMap.putIfAbsent(file, new HashMap<>());

                    // ignore duplicate version
                    if (!fileMap.get(file).containsKey(version)) {
                        fileMap.get(file).put(version, size);
                        latestVersion.put(file, version);
                    }
                    break;

                case "FETCH":
                    file = input[1];

                    if (!fileMap.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<Map.Entry<String, Integer>> list =
                            new ArrayList<>(fileMap.get(file).entrySet());

                    // sort by size, then version
                    list.sort((a, b) -> {
                        if (!a.getValue().equals(b.getValue()))
                            return a.getValue() - b.getValue();
                        return a.getKey().compareTo(b.getKey());
                    });

                    for (Map.Entry<String, Integer> e : list) {
                        System.out.println(file + " " + e.getKey() + " " + e.getValue());
                    }
                    break;

                case "LATEST":
                    file = input[1];

                    if (!fileMap.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    String v = latestVersion.get(file);
                    int s = fileMap.get(file).get(v);

                    System.out.println(file + " " + v + " " + s);
                    break;

                case "TOTAL_STORAGE":
                    file = input[1];

                    if (!fileMap.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    int total = 0;
                    for (int val : fileMap.get(file).values()) {
                        total += val;
                    }

                    System.out.println(file + " " + total);
                    break;
            }
        }
    }
}