public class FlipKeyLogicalProblem{
    public static void main(String[] args) {
        String str="RamRamJi";
        String flipString=CleanseAndInvert(str);
        if(flipString.equals("")){
            System.out.println("InvalidInput");
        }
        else{
            System.out.println("The generated key is: "+flipString);
        }
    }
    public static String CleanseAndInvert(String input){
        if (input == null || input.length() < 6) {
            return "";
        }

        // rule 2
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isLetter(input.charAt(i))){
                return "";
            }

        }
        input = input.toLowerCase();
        //remove characters with even ascii code
        StringBuilder filtered=new StringBuilder();
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch%2!=0){
                filtered.append(ch);
            }
        }
        filtered.reverse();
        for (int i = 0; i < filtered.length(); i++) {
          if(i%2==0){
            filtered.setCharAt(i,Character.toUpperCase(filtered.charAt(i)));
          }   
        }
        return filtered.toString();
    }
}