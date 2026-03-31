package extra;

public class VowelConsonant {
	 public static int[] countVowelsConsonants(String str) {
	        int vowels = 0, consonants = 0;
	        str = str.toLowerCase();
	        
	        for (char c : str.toCharArray()) {
	            if (Character.isLetter(c)) {
	                if ("aeiou".indexOf(c) != -1) {
	                    vowels++;
	                } else {
	                    consonants++;
	                }
	            }
	        }
	        
	        return new int[]{vowels, consonants};
	    }
	    
	    public static void main(String[] args) {
	        String input = "Hello World";
	        int[] result = countVowelsConsonants(input);
	        
	        System.out.println("String: " + input);
	        System.out.println("Vowels: " + result[0]);
	        System.out.println("Consonants: " + result[1]);
	    }
}
