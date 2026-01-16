public class SmartHomeSystem {
    public static void main(String[] args) {
        Device device1 = new Device("D001", "Online");
        Thermostat thermostat1 = new Thermostat("T001", "Active", 22.5);
        
        System.out.println("Smart Home Device System");
        System.out.println("========================");
        
        System.out.println("General Device:");
        device1.displayStatus();
        System.out.println();
        
        System.out.println("Smart Thermostat:");
        thermostat1.displayStatus();
    }
}