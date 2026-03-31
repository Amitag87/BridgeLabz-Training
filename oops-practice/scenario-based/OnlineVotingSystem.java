import java.util.*;

// Exception Classes
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

class VoterNotRegisteredException extends Exception {
    public VoterNotRegisteredException(String message) {
        super(message);
    }
}

// Core Classes
class Voter {
    private String voterId;
    private String name;
    private String email;
    private int age;
    private boolean hasVoted;
    
    public Voter(String voterId, String name, String email, int age) {
        this.voterId = voterId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hasVoted = false;
    }
    
    // Getters and Setters
    public String getVoterId() { return voterId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public boolean hasVoted() { return hasVoted; }
    public void setHasVoted(boolean hasVoted) { this.hasVoted = hasVoted; }
}

class Candidate {
    private String candidateId;
    private String name;
    private String party;
    private String manifesto;
    private int voteCount;
    
    public Candidate(String candidateId, String name, String party, String manifesto) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
        this.manifesto = manifesto;
        this.voteCount = 0;
    }
    
    public void incrementVoteCount() {
        voteCount++;
    }
    
    // Getters
    public String getCandidateId() { return candidateId; }
    public String getName() { return name; }
    public String getParty() { return party; }
    public String getManifesto() { return manifesto; }
    public int getVoteCount() { return voteCount; }
}

class Vote {
    private String voteId;
    private String voterId;
    private String candidateId;
    private Date timestamp;
    
    public Vote(String voteId, String voterId, String candidateId) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.timestamp = new Date();
    }
    
    // Getters
    public String getVoteId() { return voteId; }
    public String getVoterId() { return voterId; }
    public String getCandidateId() { return candidateId; }
    public Date getTimestamp() { return timestamp; }
}

class Election {
    private String electionId;
    private String electionName;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    
    public Election(String electionId, String electionName, Date startDate, Date endDate) {
        this.electionId = electionId;
        this.electionName = electionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = false;
    }
    
    // Getters and Setters
    public String getElectionId() { return electionId; }
    public String getElectionName() { return electionName; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
}

// Abstract Election Service
abstract class ElectionService {
    protected Map<String, Voter> voters;
    protected Map<String, Candidate> candidates;
    protected Map<String, Vote> votes;
    protected Election currentElection;
    
    public ElectionService() {
        this.voters = new HashMap<>();
        this.candidates = new HashMap<>();
        this.votes = new HashMap<>();
    }
    
    // Abstract methods
    public abstract void registerVoter(Voter voter);
    public abstract void addCandidate(Candidate candidate);
    public abstract void castVote(String voterId, String candidateId) throws DuplicateVoteException, VoterNotRegisteredException;
    public abstract Map<String, Integer> getResults();
}

// Concrete Implementation
class OnlineElectionService extends ElectionService {
    private int voteCounter = 1;
    
    @Override
    public void registerVoter(Voter voter) {
        if (voter.getAge() >= 18) {
            voters.put(voter.getVoterId(), voter);
            System.out.println("Voter registered: " + voter.getName());
        } else {
            System.out.println("Voter must be 18 or older to register");
        }
    }
    
    @Override
    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getCandidateId(), candidate);
        System.out.println("Candidate added: " + candidate.getName() + " (" + candidate.getParty() + ")");
    }
    
    @Override
    public void castVote(String voterId, String candidateId) throws DuplicateVoteException, VoterNotRegisteredException {
        // Check if election is active
        if (currentElection == null || !currentElection.isActive()) {
            throw new VoterNotRegisteredException("No active election");
        }
        
        // Check if voter is registered
        Voter voter = voters.get(voterId);
        if (voter == null) {
            throw new VoterNotRegisteredException("Voter not registered: " + voterId);
        }
        
        // Check if voter has already voted
        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already cast their vote: " + voterId);
        }
        
        // Check if candidate exists
        Candidate candidate = candidates.get(candidateId);
        if (candidate == null) {
            throw new VoterNotRegisteredException("Candidate not found: " + candidateId);
        }
        
        // Cast vote
        String voteId = "VOTE" + String.format("%04d", voteCounter++);
        Vote vote = new Vote(voteId, voterId, candidateId);
        votes.put(voteId, vote);
        
        // Update voter status and candidate vote count
        voter.setHasVoted(true);
        candidate.incrementVoteCount();
        
        System.out.println("Vote cast successfully by voter: " + voter.getName());
    }
    
    @Override
    public Map<String, Integer> getResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Candidate candidate : candidates.values()) {
            results.put(candidate.getName() + " (" + candidate.getParty() + ")", candidate.getVoteCount());
        }
        return results;
    }
    
    public void startElection(Election election) {
        this.currentElection = election;
        election.setActive(true);
        System.out.println("Election started: " + election.getElectionName());
    }
    
    public void endElection() {
        if (currentElection != null) {
            currentElection.setActive(false);
            System.out.println("Election ended: " + currentElection.getElectionName());
        }
    }
    
    public void displayCandidates() {
        System.out.println("\\n=== Candidates ===");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getCandidateId() + ": " + candidate.getName() + 
                             " (" + candidate.getParty() + ")");
            System.out.println("   Manifesto: " + candidate.getManifesto());
        }
    }
    
    public void declareResults() {
        System.out.println("\\n=== ELECTION RESULTS ===");
        Map<String, Integer> results = getResults();
        
        // Sort by vote count
        List<Map.Entry<String, Integer>> sortedResults = new ArrayList<>(results.entrySet());
        sortedResults.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int totalVotes = votes.size();
        System.out.println("Total votes cast: " + totalVotes);
        System.out.println("\\nResults:");
        
        for (int i = 0; i < sortedResults.size(); i++) {
            Map.Entry<String, Integer> entry = sortedResults.get(i);
            double percentage = totalVotes > 0 ? (entry.getValue() * 100.0 / totalVotes) : 0;
            
            System.out.println((i + 1) + ". " + entry.getKey() + 
                             ": " + entry.getValue() + " votes (" + 
                             String.format("%.1f", percentage) + "%)");
        }
        
        if (!sortedResults.isEmpty()) {
            System.out.println("\\nWINNER: " + sortedResults.get(0).getKey());
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {
        OnlineElectionService votingSystem = new OnlineElectionService();
        
        try {
            // Create election
            Date startDate = new Date();
            Date endDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // 24 hours later
            Election election = new Election("E001", "General Election 2024", startDate, endDate);
            
            // Register voters
            votingSystem.registerVoter(new Voter("V001", "John Doe", "john@email.com", 25));
            votingSystem.registerVoter(new Voter("V002", "Jane Smith", "jane@email.com", 30));
            votingSystem.registerVoter(new Voter("V003", "Bob Johnson", "bob@email.com", 35));
            votingSystem.registerVoter(new Voter("V004", "Alice Brown", "alice@email.com", 17)); // Underage
            
            // Add candidates
            votingSystem.addCandidate(new Candidate("C001", "Alice Wilson", "Progressive Party", "Education and Healthcare reform"));
            votingSystem.addCandidate(new Candidate("C002", "Bob Davis", "Conservative Party", "Economic growth and security"));
            votingSystem.addCandidate(new Candidate("C003", "Carol Miller", "Green Party", "Environmental protection"));
            
            // Start election
            votingSystem.startElection(election);
            
            // Display candidates
            votingSystem.displayCandidates();
            
            // Cast votes
            votingSystem.castVote("V001", "C001");
            votingSystem.castVote("V002", "C002");
            votingSystem.castVote("V003", "C001");
            
            // Try to vote again (should throw exception)
            try {
                votingSystem.castVote("V001", "C002");
            } catch (DuplicateVoteException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Try to vote with unregistered voter
            try {
                votingSystem.castVote("V999", "C001");
            } catch (VoterNotRegisteredException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // End election and declare results
            votingSystem.endElection();
            votingSystem.declareResults();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}