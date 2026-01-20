import java.util.*;

abstract class JobRole {
    String roleName;
    List<String> requiredSkills;
    
    JobRole(String roleName, List<String> requiredSkills) {
        this.roleName = roleName;
        this.requiredSkills = requiredSkills;
    }
    
    abstract int calculateScore(List<String> candidateSkills);
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer", Arrays.asList("Java", "Python", "SQL", "Git"));
    }
    
    int calculateScore(List<String> candidateSkills) {
        int score = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) score += 25;
        }
        return score;
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist", Arrays.asList("Python", "R", "Machine Learning", "Statistics"));
    }
    
    int calculateScore(List<String> candidateSkills) {
        int score = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) score += 25;
        }
        return score;
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager", Arrays.asList("Strategy", "Analytics", "Communication", "Leadership"));
    }
    
    int calculateScore(List<String> candidateSkills) {
        int score = 0;
        for (String skill : requiredSkills) {
            if (candidateSkills.contains(skill)) score += 25;
        }
        return score;
    }
}

class Resume<T extends JobRole> {
    String candidateName;
    List<String> skills;
    T targetRole;
    int score;
    
    Resume(String candidateName, List<String> skills, T targetRole) {
        this.candidateName = candidateName;
        this.skills = skills;
        this.targetRole = targetRole;
        this.score = targetRole.calculateScore(skills);
    }
    
    void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Target Role: " + targetRole.roleName);
        System.out.println("Skills: " + skills);
        System.out.println("Score: " + score + "/100");
        System.out.println("Status: " + (score >= 75 ? "SELECTED" : score >= 50 ? "INTERVIEW" : "REJECTED"));
    }
}

public class AIResumeScreeningSystem {
    public static void screenAllResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("=== AI Resume Screening Results ===");
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResume();
            System.out.println();
        }
    }
    
    public static <T extends JobRole> Resume<T> processResume(String name, List<String> skills, T role) {
        Resume<T> resume = new Resume<>(name, skills, role);
        System.out.println("Processed resume for: " + name + " (Role: " + role.roleName + ")");
        return resume;
    }
    
    public static void main(String[] args) {
        // Create resumes for different roles
        Resume<SoftwareEngineer> seResume = processResume(
            "Alice Johnson", 
            Arrays.asList("Java", "Python", "Git", "Spring"), 
            new SoftwareEngineer()
        );
        
        Resume<DataScientist> dsResume = processResume(
            "Bob Smith", 
            Arrays.asList("Python", "Machine Learning", "TensorFlow", "Statistics"), 
            new DataScientist()
        );
        
        Resume<ProductManager> pmResume = processResume(
            "Carol Davis", 
            Arrays.asList("Strategy", "Analytics", "Leadership", "Agile"), 
            new ProductManager()
        );
        
        Resume<SoftwareEngineer> seResume2 = processResume(
            "David Wilson", 
            Arrays.asList("JavaScript", "React", "Node.js"), 
            new SoftwareEngineer()
        );
        
        // Screen all resumes using wildcards
        List<Resume<? extends JobRole>> allResumes = new ArrayList<>();
        allResumes.add(seResume);
        allResumes.add(dsResume);
        allResumes.add(pmResume);
        allResumes.add(seResume2);
        
        screenAllResumes(allResumes);
    }
}