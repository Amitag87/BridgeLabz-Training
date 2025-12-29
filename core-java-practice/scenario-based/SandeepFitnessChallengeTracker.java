package scenariobased;


public class SandeepFitnessChallengeTracker {

    public static void main(String[] args) {

        int[] weeklyPushUps = {30, 0, 25, 40, 0, 35, 20};

        int totalPushUps = 0;
        int activeDays = 0;

        for (int pushUps : weeklyPushUps) {

            if (pushUps == 0) {
                continue;
            }

            totalPushUps += pushUps;
            activeDays++;
        }

        double averagePushUps = (activeDays > 0) 
                                ? (double) totalPushUps / activeDays 
                                : 0;

        System.out.println("Total Push-ups this week: " + totalPushUps);
        System.out.println("Average Push-ups per active day: " + averagePushUps);
    }
}
