import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    
    Policy(String policyNumber, String holderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = LocalDate.parse(expiryDate);
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    
    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %.2f]", 
            policyNumber, holderName, expiryDate, coverageType, premiumAmount);
    }
    
    public boolean isExpiringSoon() {
        return expiryDate.isBefore(LocalDate.now().plusDays(30));
    }
}

public class InsurancePolicyManagementSystem {
    private HashSet<Policy> hashSetPolicies;
    private LinkedHashSet<Policy> linkedHashSetPolicies;
    private TreeSet<Policy> treeSetPolicies;
    
    public InsurancePolicyManagementSystem() {
        this.hashSetPolicies = new HashSet<>();
        this.linkedHashSetPolicies = new LinkedHashSet<>();
        this.treeSetPolicies = new TreeSet<>();
    }
    
    // Store policies in different sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    
    // Retrieve all unique policies
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }
    
    // Policies expiring soon
    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.isExpiringSoon()) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }
    
    // Policies by coverage type
    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> filtered = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.coverageType.equals(coverageType)) {
                filtered.add(policy);
            }
        }
        return filtered;
    }
    
    // Performance comparison
    public void performanceComparison(List<Policy> policies) {
        System.out.println("\\n=== Performance Comparison ===");
        
        // HashSet performance
        long start = System.nanoTime();
        Set<Policy> hashSet = new HashSet<>();
        for (Policy p : policies) hashSet.add(p);
        for (Policy p : policies) hashSet.contains(p);
        for (Policy p : policies) hashSet.remove(p);
        long hashTime = System.nanoTime() - start;
        
        // LinkedHashSet performance
        start = System.nanoTime();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        for (Policy p : policies) linkedHashSet.add(p);
        for (Policy p : policies) linkedHashSet.contains(p);
        for (Policy p : policies) linkedHashSet.remove(p);
        long linkedHashTime = System.nanoTime() - start;
        
        // TreeSet performance
        start = System.nanoTime();
        Set<Policy> treeSet = new TreeSet<>();
        for (Policy p : policies) treeSet.add(p);
        for (Policy p : policies) treeSet.contains(p);
        for (Policy p : policies) treeSet.remove(p);
        long treeTime = System.nanoTime() - start;
        
        System.out.println("HashSet time: " + hashTime / 1000 + " μs");
        System.out.println("LinkedHashSet time: " + linkedHashTime / 1000 + " μs");
        System.out.println("TreeSet time: " + treeTime / 1000 + " μs");
    }
    
    public void displayPolicies() {
        System.out.println("\\nHashSet (Random order): " + hashSetPolicies);
        System.out.println("LinkedHashSet (Insertion order): " + linkedHashSetPolicies);
        System.out.println("TreeSet (Sorted by expiry): " + treeSetPolicies);
    }
    
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        
        // Add policies
        system.addPolicy(new Policy("P001", "John Doe", "2025-02-15", "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Jane Smith", "2025-01-20", "Auto", 800.0));
        system.addPolicy(new Policy("P003", "Bob Johnson", "2025-03-10", "Home", 1500.0));
        system.addPolicy(new Policy("P004", "Alice Brown", "2025-01-25", "Health", 1100.0));
        
        system.displayPolicies();
        
        System.out.println("\\nPolicies expiring soon: " + system.getPoliciesExpiringSoon());
        System.out.println("Health policies: " + system.getPoliciesByCoverage("Health"));
        
        // Performance test
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, "2025-06-01", "Test", 1000.0));
        }
        system.performanceComparison(testPolicies);
    }
}