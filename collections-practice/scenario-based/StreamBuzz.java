import java.util.*;

class CreatorStats {
    String creatorName;
    double[] weeklyLikes;

    public static List<CreatorStats> engagementboard = new ArrayList<>();
}

public class StreamBuzz {

    public void RegisterCreator(CreatorStats record) {
        CreatorStats.engagementboard.add(record);
    }

    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;
            for (double like : creator.weeklyLikes) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.creatorName, count);
            }
        }
        return result;
    }

    public double calculateAverageLikes() {
        double total = 0;
        int count = 0;

        for (CreatorStats creator : CreatorStats.engagementboard) {
            for (double like : creator.weeklyLikes) {
                total += like;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzz sb = new StreamBuzz();

        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    CreatorStats creator = new CreatorStats();
                    creator.weeklyLikes = new double[4];

                    System.out.println("Enter Creator Name:");
                    creator.creatorName = sc.nextLine();

                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        creator.weeklyLikes[i] = sc.nextDouble();
                    }

                    sb.RegisterCreator(creator);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> topPosts =
                            sb.getTopPostCounts(CreatorStats.engagementboard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avgLikes = sb.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + avgLikes);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
