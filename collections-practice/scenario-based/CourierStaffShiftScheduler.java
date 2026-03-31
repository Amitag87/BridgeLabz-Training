import java.util.*;

class ShiftAlreadyAssignedException extends Exception {
    public ShiftAlreadyAssignedException(String message) {
        super(message);
    }
}

enum ShiftTime {
    MORNING("06:00-14:00"),
    AFTERNOON("14:00-22:00"),
    NIGHT("22:00-06:00");
    
    private String timeRange;
    
    ShiftTime(String timeRange) {
        this.timeRange = timeRange;
    }
    
    public String getTimeRange() { return timeRange; }
}

class Employee {
    private String employeeId;
    private String name;
    private String contactNumber;
    private Set<ShiftTime> assignedShifts;
    
    public Employee(String employeeId, String name, String contactNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.assignedShifts = new HashSet<>();
    }
    
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public Set<ShiftTime> getAssignedShifts() { return assignedShifts; }
    
    public void addShift(ShiftTime shift) {
        assignedShifts.add(shift);
    }
    
    public boolean hasShift(ShiftTime shift) {
        return assignedShifts.contains(shift);
    }
    
    @Override
    public String toString() {
        return employeeId + " - " + name + " (" + contactNumber + ")";
    }
}

class ShiftScheduler {
    private List<Employee> employees;
    private Map<ShiftTime, List<Employee>> shiftAssignments;
    
    public ShiftScheduler() {
        employees = new ArrayList<>();
        shiftAssignments = new HashMap<>();
        for (ShiftTime shift : ShiftTime.values()) {
            shiftAssignments.put(shift, new ArrayList<>());
        }
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }
    
    public void assignShift(String employeeId, ShiftTime shift) throws ShiftAlreadyAssignedException {
        Employee employee = findEmployee(employeeId);
        
        if (employee == null) {
            System.out.println("Employee not found: " + employeeId);
            return;
        }
        
        if (employee.hasShift(shift)) {
            throw new ShiftAlreadyAssignedException("Employee " + employee.getName() + 
                                                   " is already assigned to " + shift + " shift");
        }
        
        employee.addShift(shift);
        shiftAssignments.get(shift).add(employee);
        System.out.println("Assigned " + employee.getName() + " to " + shift + " shift (" + 
                         shift.getTimeRange() + ")");
    }
    
    private Employee findEmployee(String employeeId) {
        return employees.stream()
                       .filter(e -> e.getEmployeeId().equals(employeeId))
                       .findFirst()
                       .orElse(null);
    }
    
    public void displayShiftSchedule() {
        System.out.println("\n=== Shift Schedule ===");
        for (Map.Entry<ShiftTime, List<Employee>> entry : shiftAssignments.entrySet()) {
            System.out.println("\n" + entry.getKey() + " (" + entry.getKey().getTimeRange() + "):");
            if (entry.getValue().isEmpty()) {
                System.out.println("  No employees assigned");
            } else {
                for (Employee emp : entry.getValue()) {
                    System.out.println("  - " + emp);
                }
            }
        }
    }
    
    public void displayEmployeeSchedule(String employeeId) {
        Employee employee = findEmployee(employeeId);
        if (employee == null) {
            System.out.println("Employee not found: " + employeeId);
            return;
        }
        
        System.out.println("\n=== Schedule for " + employee.getName() + " ===");
        if (employee.getAssignedShifts().isEmpty()) {
            System.out.println("No shifts assigned");
        } else {
            for (ShiftTime shift : employee.getAssignedShifts()) {
                System.out.println("  - " + shift + " (" + shift.getTimeRange() + ")");
            }
        }
    }
}

public class CourierStaffShiftScheduler {
    public static void main(String[] args) {
        ShiftScheduler scheduler = new ShiftScheduler();
        
        System.out.println("=== Courier Staff Shift Scheduler ===\n");
        
        scheduler.addEmployee(new Employee("E001", "John Doe", "9876543210"));
        scheduler.addEmployee(new Employee("E002", "Alice Smith", "9876543211"));
        scheduler.addEmployee(new Employee("E003", "Bob Johnson", "9876543212"));
        scheduler.addEmployee(new Employee("E004", "Sarah Wilson", "9876543213"));
        
        System.out.println("\n=== Assigning Shifts ===");
        
        try {
            scheduler.assignShift("E001", ShiftTime.MORNING);
            scheduler.assignShift("E001", ShiftTime.AFTERNOON);
            scheduler.assignShift("E002", ShiftTime.MORNING);
            scheduler.assignShift("E003", ShiftTime.NIGHT);
            scheduler.assignShift("E004", ShiftTime.AFTERNOON);
            
            System.out.println("\n=== Attempting Duplicate Assignment ===");
            scheduler.assignShift("E001", ShiftTime.MORNING);
            
        } catch (ShiftAlreadyAssignedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scheduler.displayShiftSchedule();
        scheduler.displayEmployeeSchedule("E001");
    }
}