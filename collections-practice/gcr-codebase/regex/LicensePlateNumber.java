public class LicensePlateNumber {
    public static void main(String[] args) {
        System.out.println(isValid("AB123"));
        
        System.out.println(isValid("A1523"));
    }
    public static boolean isValid(String username){
        String regex="^[A-Z]{2}[0-9]{3}$";
        return username.matches(regex);
    }
}
