package strings;

public class VotingEligibilityChecker {

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = ages[i] >= 18 ? "Can Vote" : "Cannot Vote";
        }
        return result;
    }
}
