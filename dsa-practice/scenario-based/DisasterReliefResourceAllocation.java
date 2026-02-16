import java.util.*;

class InsufficientResourceException extends Exception {
    public InsufficientResourceException(String message) {
        super(message);
    }
}

class AreaRequest {
    private String areaName;
    private Map<String, Integer> requestedResources;
    
    public AreaRequest(String areaName, Map<String, Integer> requestedResources) {
        this.areaName = areaName;
        this.requestedResources = requestedResources;
    }
    
    public String getAreaName() { return areaName; }
    public Map<String, Integer> getRequestedResources() { return requestedResources; }
}

class ReliefCenter {
    private String centerName;
    private Map<String, Integer> resources;
    
    public ReliefCenter(String centerName) {
        this.centerName = centerName;
        this.resources = new HashMap<>();
    }
    
    public void addResource(String item, int quantity) {
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }
    
    public boolean hasEnoughResources(Map<String, Integer> requested) {
        for (Map.Entry<String, Integer> entry : requested.entrySet()) {
            if (resources.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public void allocateResources(Map<String, Integer> requested) {
        for (Map.Entry<String, Integer> entry : requested.entrySet()) {
            resources.put(entry.getKey(), resources.get(entry.getKey()) - entry.getValue());
        }
    }
    
    public String getCenterName() { return centerName; }
    public Map<String, Integer> getResources() { return resources; }
}

class DisasterReliefSystem {
    private Map<String, ReliefCenter> reliefCenters;
    private Queue<AreaRequest> areaRequests;
    private List<String> allocationReport;
    
    public DisasterReliefSystem() {
        reliefCenters = new HashMap<>();
        areaRequests = new LinkedList<>();
        allocationReport = new ArrayList<>();
    }
    
    public void addReliefCenter(String centerName) {
        reliefCenters.put(centerName, new ReliefCenter(centerName));
    }
    
    public void addResourceToCenter(String centerName, String item, int quantity) {
        if (reliefCenters.containsKey(centerName)) {
            reliefCenters.get(centerName).addResource(item, quantity);
        }
    }
    
    public void addAreaRequest(String areaName, Map<String, Integer> resources) {
        areaRequests.offer(new AreaRequest(areaName, resources));
    }
    
    public void allocateResources() throws InsufficientResourceException {
        while (!areaRequests.isEmpty()) {
            AreaRequest request = areaRequests.poll();
            boolean allocated = false;
            
            for (ReliefCenter center : reliefCenters.values()) {
                if (center.hasEnoughResources(request.getRequestedResources())) {
                    center.allocateResources(request.getRequestedResources());
                    allocationReport.add("Allocated to " + request.getAreaName() + 
                                       " from " + center.getCenterName() + ": " + 
                                       request.getRequestedResources());
                    allocated = true;
                    break;
                }
            }
            
            if (!allocated) {
                throw new InsufficientResourceException("Insufficient resources for area: " + request.getAreaName());
            }
        }
    }
    
    public void generateAllocationReport() {
        System.out.println("=== Allocation Report ===");
        for (String record : allocationReport) {
            System.out.println(record);
        }
        
        System.out.println("\n=== Remaining Resources ===");
        for (Map.Entry<String, ReliefCenter> entry : reliefCenters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getResources());
        }
    }
}

public class DisasterReliefResourceAllocation {
    public static void main(String[] args) {
        DisasterReliefSystem system = new DisasterReliefSystem();
        
        system.addReliefCenter("Center-A");
        system.addReliefCenter("Center-B");
        
        system.addResourceToCenter("Center-A", "Food", 500);
        system.addResourceToCenter("Center-A", "Water", 1000);
        system.addResourceToCenter("Center-A", "Medical Kits", 200);
        
        system.addResourceToCenter("Center-B", "Food", 300);
        system.addResourceToCenter("Center-B", "Water", 800);
        system.addResourceToCenter("Center-B", "Medical Kits", 150);
        
        Map<String, Integer> req1 = new HashMap<>();
        req1.put("Food", 200);
        req1.put("Water", 400);
        req1.put("Medical Kits", 50);
        system.addAreaRequest("Area-1", req1);
        
        Map<String, Integer> req2 = new HashMap<>();
        req2.put("Food", 150);
        req2.put("Water", 300);
        req2.put("Medical Kits", 80);
        system.addAreaRequest("Area-2", req2);
        
        Map<String, Integer> req3 = new HashMap<>();
        req3.put("Food", 100);
        req3.put("Water", 200);
        req3.put("Medical Kits", 40);
        system.addAreaRequest("Area-3", req3);
        
        try {
            system.allocateResources();
            system.generateAllocationReport();
        } catch (InsufficientResourceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
