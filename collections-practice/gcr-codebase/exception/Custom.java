class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class Custom{
    public static void main(String[] args) {
        int age=2;
        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    public static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("age is not valid");
        }
        else{
            System.out.println("Age is valid");
        }
    }
}
