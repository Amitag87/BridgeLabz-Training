import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }
    
    public List<Book> searchByTitle(String partialTitle) {
        List<Book> results = new ArrayList<>();
        String searchTerm = partialTitle.toLowerCase();
        
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm)) {
                results.add(book);
            }
        }
        return results;
    }
    
    public void displayBooks() {
        System.out.println("=== Library Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    public void checkoutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                try {
                    book.checkout();
                    System.out.println("Book checked out: " + title);
                    return;
                } catch (BookNotAvailableException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Book not found: " + title);
    }
    
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }
    
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        
        library.addBook("Java Programming", "John Smith");
        library.addBook("Data Structures", "Jane Doe");
        library.addBook("Java Advanced", "Bob Johnson");
        
        library.displayBooks();
        
        System.out.println("\nSearching for 'Java':");
        List<Book> results = library.searchByTitle("Java");
        for (Book book : results) {
            System.out.println(book);
        }
        
        library.checkoutBook("Java Programming");
        library.checkoutBook("Java Programming"); // Should fail
        
        library.displayBooks();
        
        library.returnBook("Java Programming");
        library.displayBooks();
    }
}