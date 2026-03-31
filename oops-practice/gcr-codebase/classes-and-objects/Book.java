public class Book {
    String title;
    String author;
    double price;
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("2States", "Chetan Bhagat", 500.0);
        Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
        
        book1.displayDetails();
        book2.displayDetails();
    }
}