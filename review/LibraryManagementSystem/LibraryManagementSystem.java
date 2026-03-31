class Book{
    private String title;
    private String author;
    private boolean isAvailable;
    public Book(String title,String author){
        this.title=title;
        this.author=author;
        this.isAvailable=true;
    }
    public void details(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Available: "+isAvailable);
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean status){
        this.isAvailable = status;
    }

}
class Member{
    private String name;
    private String memberId;
    public Member(String name,String memberId){
        this.name=name;
        this.memberId=memberId;
    }
    public void details(){
        System.out.println("Name: "+name);
        System.out.println("Member ID: "+memberId);
    }
}
class User extends Member{
    public User(String name,String memberId){
        super(name,memberId);
    }
}
class Transaction{
    private Member member;
    private Book book;
    public Transaction(Member member,Book book){
        this.member=member;
        this.book=book;
    }
}
interface FineCalculator{
    double calculateFine(int lateDays);
}
class Student extends Member{
    public Student(String name,String memberId){
        super(name,memberId);
    }
}
class StudentFineCalculator implements FineCalculator{
    private static final double fine=1.0;
    @Override
    public double calculateFine(int lateDays){
        return lateDays*fine;
    }
}
class BookNotAvailableException extends Exception{
    public BookNotAvailableException(String message){
        super(message);
    }
}



public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book("Friday Funday", "Garvit");
        Book book2 = new Book("Java Programming","Shauraya");
        Member member = new Member("Rahul", "123");
        book1.details();
        member.details();
        Student student=new Student("Rahul","12345");
        FineCalculator fineCalculator=new StudentFineCalculator();
        System.out.println("Fine for late return: "+fineCalculator.calculateFine(5));
    }
    public static void issueBook(Member member,Book book) throws BookNotAvailableException{
        if(!book.isAvailable()){
            throw new BookNotAvailableException("Book is not available");
        }
        book.setAvailable(true);
    }
}
