
public class ValidateUsername {
    public static void main(String[] args) {
        System.out.println(isValid("user_123"));
        System.out.println(isValid("123user"));
        System.out.println(isValid("us"));
        
    }
    public static boolean isValid(String username){
        String regex="^[A-Za-z][A-Za-z0-9_]{4,14}$";
        return username.matches(regex);
        
    }
}
