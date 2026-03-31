public class ValidateCreditCard {
    public static void main(String[] args) {
        String[] cards = {"4123456789012345", "5123456789012345", "3123456789012345", "41234567890123456"};
        
        for (String card : cards) {
            System.out.println(card + " -> " + validateCard(card));
        }
    }
    
    public static String validateCard(String card) {
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";
        
        if (card.matches(visaRegex)) {
            return "Valid Visa";
        } else if (card.matches(masterCardRegex)) {
            return "Valid MasterCard";
        } else {
            return "Invalid";
        }
    }
}