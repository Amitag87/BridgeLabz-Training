import java.util.*;

class DuplicateAttendanceException extends Exception {
    public DuplicateAttendanceException(String message) {
        super(message);
    }
}

class AttendanceTracker {
    private Set<String> allStudents = new HashSet<>();
    private Map<String, Set<String>> sessionAttendance = new HashMap<>();
    
    public void registerStudent(String studentId) {
        allStudents.add(studentId);
    }
    
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
        sessionAttendance.putIfAbsent(sessionId, new HashSet<>());
        
        if (sessionAttendance.get(sessionId).contains(studentId)) {
            throw new DuplicateAttendanceException("Student " + studentId + " already marked present in session " + sessionId);
        }
        
        sessionAttendance.get(sessionId).add(studentId);
        System.out.println("Attendance marked for Student " + studentId + " in Session " + sessionId);
    }
    
    public void removeAttendance(String sessionId, String studentId) {
        if (sessionAttendance.containsKey(sessionId)) {
            if (sessionAttendance.get(sessionId).remove(studentId)) {
                System.out.println("Attendance removed for Student " + studentId + " from Session " + sessionId);
            } else {
                System.out.println("Student " + studentId + " not found in Session " + sessionId);
            }
        } else {
            System.out.println("Session " + sessionId + " not found");
        }
    }
    
    public void displayAttendance(String sessionId) {
        if (sessionAttendance.containsKey(sessionId)) {
            Set<String> attendees = sessionAttendance.get(sessionId);
            System.out.println("Session " + sessionId + " Attendance (" + attendees.size() + " students):");
            for (String student : attendees) {
                System.out.println("- " + student);
            }
        } else {
            System.out.println("No attendance recorded for Session " + sessionId);
        }
    }
    
    public void displayAllSessions() {
        System.out.println("All Sessions:");
        for (String sessionId : sessionAttendance.keySet()) {
            System.out.println("Session " + sessionId + ": " + sessionAttendance.get(sessionId).size() + " students");
        }
    }
    
    public void getAttendanceReport(String studentId) {
        System.out.println("Attendance Report for Student " + studentId + ":");
        for (Map.Entry<String, Set<String>> entry : sessionAttendance.entrySet()) {
            if (entry.getValue().contains(studentId)) {
                System.out.println("- Present in Session " + entry.getKey());
            }
        }
    }
}

public class OnlineClassroomAttendance {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();
        
        // Register students
        tracker.registerStudent("S001");
        tracker.registerStudent("S002");
        tracker.registerStudent("S003");
        
        try {
            // Mark attendance for different sessions
            tracker.markAttendance("JAVA101", "S001");
            tracker.markAttendance("JAVA101", "S002");
            tracker.markAttendance("JAVA102", "S001");
            tracker.markAttendance("JAVA102", "S003");
            
            // Display attendance
            tracker.displayAttendance("JAVA101");
            tracker.displayAttendance("JAVA102");
            
            // Try duplicate attendance - should throw exception
            tracker.markAttendance("JAVA101", "S001");
            
        } catch (DuplicateAttendanceException e) {
            System.out.println(e.getMessage());
        }
        
        // Remove attendance
        tracker.removeAttendance("JAVA101", "S002");
        tracker.displayAttendance("JAVA101");
        
        // Display all sessions and student report
        tracker.displayAllSessions();
        tracker.getAttendanceReport("S001");
    }
}