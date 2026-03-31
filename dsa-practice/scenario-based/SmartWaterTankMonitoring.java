import java.util.*;

class InvalidWaterLevelException extends Exception {
    public InvalidWaterLevelException(String message) {
        super(message);
    }
}

class WaterTank {
    private String tankId;
    private double capacity;
    private double currentLevel;
    
    public WaterTank(String tankId, double capacity, double currentLevel) throws InvalidWaterLevelException {
        this.tankId = tankId;
        this.capacity = capacity;
        setCurrentLevel(currentLevel);
    }
    
    public void setCurrentLevel(double level) throws InvalidWaterLevelException {
        if (level > capacity) {
            throw new InvalidWaterLevelException("Water level exceeds capacity for tank: " + tankId);
        }
        this.currentLevel = level;
    }
    
    public double getUsagePercentage() {
        return (currentLevel / capacity) * 100;
    }
    
    public boolean isLowLevel() {
        return getUsagePercentage() < 20;
    }
    
    public String getTankId() { return tankId; }
    public double getCapacity() { return capacity; }
    public double getCurrentLevel() { return currentLevel; }
    
    @Override
    public String toString() {
        return String.format("Tank %s: %.2f/%.2f L (%.2f%%)", 
                           tankId, currentLevel, capacity, getUsagePercentage());
    }
}

class WaterTankMonitoringSystem {
    private List<WaterTank> tanks;
    
    public WaterTankMonitoringSystem() {
        tanks = new ArrayList<>();
    }
    
    public void addTank(String tankId, double capacity, double currentLevel) throws InvalidWaterLevelException {
        tanks.add(new WaterTank(tankId, capacity, currentLevel));
    }
    
    public void updateTankLevel(String tankId, double newLevel) throws InvalidWaterLevelException {
        for (WaterTank tank : tanks) {
            if (tank.getTankId().equals(tankId)) {
                tank.setCurrentLevel(newLevel);
                return;
            }
        }
        System.out.println("Tank not found: " + tankId);
    }
    
    public void checkAlerts() {
        System.out.println("=== Low Level Alerts ===");
        boolean hasAlerts = false;
        for (WaterTank tank : tanks) {
            if (tank.isLowLevel()) {
                System.out.println("ALERT: " + tank + " - Below 20% threshold!");
                hasAlerts = true;
            }
        }
        if (!hasAlerts) {
            System.out.println("No alerts - All tanks above threshold");
        }
    }
    
    public void sortByLowestLevel() {
        Collections.sort(tanks, new Comparator<WaterTank>() {
            @Override
            public int compare(WaterTank t1, WaterTank t2) {
                return Double.compare(t1.getCurrentLevel(), t2.getCurrentLevel());
            }
        });
    }
    
    public void displayTanks() {
        System.out.println("\n=== Water Tank Status ===");
        for (WaterTank tank : tanks) {
            System.out.println(tank);
        }
    }
}

public class SmartWaterTankMonitoring {
    public static void main(String[] args) {
        WaterTankMonitoringSystem system = new WaterTankMonitoringSystem();
        
        try {
            system.addTank("T1", 1000, 850);
            system.addTank("T2", 1500, 200);
            system.addTank("T3", 2000, 150);
            system.addTank("T4", 1200, 1100);
            system.addTank("T5", 1800, 300);
            
            system.displayTanks();
            system.checkAlerts();
            
            System.out.println("\n=== Sorted by Lowest Level ===");
            system.sortByLowestLevel();
            system.displayTanks();
            
            System.out.println("\n=== Testing Invalid Level ===");
            system.updateTankLevel("T1", 1200);
            
        } catch (InvalidWaterLevelException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
