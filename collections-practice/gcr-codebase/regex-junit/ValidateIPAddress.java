public class ValidateIPAddress {
    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "256.1.1.1", "192.168.1", "10.0.0.1"};
        
        for (String ip : ips) {
            System.out.println(ip + " -> " + (isValidIP(ip) ? "Valid" : "Invalid"));
        }
    }
    
    public static boolean isValidIP(String ip) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return ip.matches(regex);
    }
}