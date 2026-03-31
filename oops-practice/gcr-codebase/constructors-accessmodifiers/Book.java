public class Book {
    public String ISBN;
    protected String title;
    private String author;
    
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
    }
}

class EBook extends Book {
    double fileSize;
    
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }
    
    public void displayEBookDetails() {
        System.out.println("EBook - ISBN: " + ISBN + ", Title: " + title + ", Size: " + fileSize + "MB");
    }
    
    public static void main(String[] args) {
        Book book = new Book("978-123", "Java Basics", "John Doe");
        book.displayDetails();
        book.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book.getAuthor());
        
        EBook ebook = new EBook("978-456", "Advanced Java", "Bob Smith", 15.5);
        ebook.displayEBookDetails();
    }
}