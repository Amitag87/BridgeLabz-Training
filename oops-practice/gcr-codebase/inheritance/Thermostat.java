public class Thermostat extends Device {
    private double temperatureSetting;
    
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    
    @Override
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}