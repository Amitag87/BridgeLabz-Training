import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Participant{
    public String participantName;
    // public String participantId;
    public int score;
    private boolean isLate;
    private Map<String,Boolean> testResults;
    public Participant(String participantName,Map<String,Boolean> testResults,boolean isLate) throws LateSubmissionException{
        if(isLate){
            throw new LateSubmissionException("Submitted late");
        }
        this.participantName=participantName;
        this.testResults=testResults;
        this.isLate=isLate;
        this.score=calculateScore();
        
    }
    public int calculateScore(){
        int total=0;
        for(Boolean result : testResults.values()){
            if(result){
                total+=10;
            }
             
        }
        return total;
    }
    public String getParticipantName(){

        return participantName;
    }
    public int getScore(){
        return score;
    }
}
class ScoreComparator implements Comparator<Participant>{

    public int compare(Participant p1,Participant p2){
        return Integer.compare(p2.getScore(),p1.getScore());
    }
}
class LateSubmissionException extends Exception{
    public LateSubmissionException(String message){
        super(message);
    }
}
public class OnlineHackathonSubmission {
    public static void main(String[] args) {
        List<Participant> participants=new ArrayList<>();
        try{
            Map<String,Boolean> result1=new HashMap<>();
            result1.put("Q1",true);
            result1.put("Q2",false);
            result1.put("Q3",false);
            participants.add(new Participant("Amit",result1,false));
            Map<String,Boolean> result2=new HashMap<>();
            result2.put("Q1",false);
            result2.put("Q2",true);
            result2.put("Q3",true);
            participants.add(new Participant("XYZ",result2,false));
            Map<String,Boolean> result3=new HashMap<>();
            result3.put("Q1",true);
            participants.add(new Participant("ABC",result3,true));

        }
        catch(LateSubmissionException e){
            System.out.println(e.getMessage());
        }
        Collections.sort(participants,new ScoreComparator());
        System.out.println("\nlederboard");
        for(Participant p:participants){
            System.out.println(p.getParticipantName());
        }
    }
}
