import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap<>();
        Map<String, Integer> voteOrder = new LinkedHashMap<>();

        castVote("Alice", votes, voteOrder);
        castVote("Bob", votes, voteOrder);
        castVote("Alice", votes, voteOrder);
        castVote("Charlie", votes, voteOrder);

        System.out.println("Vote Order:");
        System.out.println(voteOrder);

        TreeMap<String, Integer> sortedResult = new TreeMap<>(votes);

        System.out.println("Final Result (Sorted):");
        System.out.println(sortedResult);
    }

    static void castVote(String candidate,
                         Map<String, Integer> votes,
                         Map<String, Integer> voteOrder) {

        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }
}
