public class HexColorCode {
    public static void main(String[] args) {
        System.out.println(isValid("#FFA500"));      
        System.out.println(isValid("#ff4500"));
        System.out.println(isValid("#123"));
    }
    public static boolean isValid(String colorCode){
        String regex = "^#[A-Fa-f0-9]{6}$";
        return colorCode.matches(regex);
    }
}
