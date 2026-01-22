import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagement {

    static Set<Policy> hashSet = new HashSet<>();
    static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    static Set<Policy> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        Policy p1 = new Policy(101, "Amit", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(102, "Rahul", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy(103, "Neha", LocalDate.now().plusDays(20), "Home", 7000);
        Policy p4 = new Policy(101, "Amit", LocalDate.now().plusDays(10), "Health", 5000);

        addPolicy(p1);
        addPolicy(p2);
        addPolicy(p3);
        addPolicy(p4);

        System.out.println("\nAll Unique Policies:");
        display(hashSet);

        System.out.println("\nPolicies Expiring Within 30 Days:");
        expiringSoon(hashSet);

        System.out.println("\nHealth Coverage Policies:");
        policiesByCoverage(hashSet, "Health");

        System.out.println("\nPolicies Sorted by Expiry Date:");
        display(treeSet);

        performanceTest();
    }

    static void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    static void display(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    static void expiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        for (Policy p : set) {
            if (!p.expiryDate.isAfter(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    static void policiesByCoverage(Set<Policy> set, String type) {
        for (Policy p : set) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    static void performanceTest() {

        Policy test = new Policy(200, "Test", LocalDate.now().plusDays(5), "Auto", 2000);

        long start, end;

        start = System.nanoTime();
        hashSet.add(test);
        hashSet.contains(test);
        hashSet.remove(test);
        end = System.nanoTime();
        System.out.println("\nHashSet Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.add(test);
        linkedHashSet.contains(test);
        linkedHashSet.remove(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Time: " + (end - start));

        start = System.nanoTime();
        treeSet.add(test);
        treeSet.contains(test);
        treeSet.remove(test);
        end = System.nanoTime();
        System.out.println("TreeSet Time: " + (end - start));
    }
}

class Policy implements Comparable<Policy> {

    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(int policyNumber, String holderName, LocalDate expiryDate,
           String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    public boolean equals(Object o) {
        Policy p = (Policy) o;
        return this.policyNumber == p.policyNumber;
    }

    public int hashCode() {
        return policyNumber;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " +
               expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}
