import java.util.*;

class Book {
    String title;
    String author;
    String isbn;
    
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class BookShelf {
    private HashMap<String, LinkedList<Book>> genreCatalog;
    private HashSet<String> allBooks; // To prevent duplicates by ISBN
    
    public BookShelf() {
        this.genreCatalog = new HashMap<>();
        this.allBooks = new HashSet<>();
    }
    
    public void addBook(String genre, Book book) {
        if (allBooks.contains(book.isbn)) {
            System.out.println("Book already exists: " + book.title);
            return;
        }
        
        genreCatalog.putIfAbsent(genre, new LinkedList<>());
        genreCatalog.get(genre).add(book);
        allBooks.add(book.isbn);
        System.out.println("Added: " + book + " to " + genre);
    }
    
    public boolean borrowBook(String genre, String isbn) {
        if (!genreCatalog.containsKey(genre)) {
            System.out.println("Genre not found: " + genre);
            return false;
        }
        
        LinkedList<Book> books = genreCatalog.get(genre);
        Iterator<Book> iterator = books.iterator();
        
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isbn.equals(isbn)) {
                iterator.remove();
                allBooks.remove(isbn);
                System.out.println("Borrowed: " + book);
                
                // Remove genre if no books left
                if (books.isEmpty()) {
                    genreCatalog.remove(genre);
                }
                return true;
            }
        }
        
        System.out.println("Book not found with ISBN: " + isbn);
        return false;
    }
    
    public void returnBook(String genre, Book book) {
        if (allBooks.contains(book.isbn)) {
            System.out.println("Book already in library: " + book.title);
            return;
        }
        
        genreCatalog.putIfAbsent(genre, new LinkedList<>());
        genreCatalog.get(genre).addFirst(book); // Add to front for recently returned
        allBooks.add(book.isbn);
        System.out.println("Returned: " + book + " to " + genre);
    }
    
    public void displayCatalog() {
        System.out.println("\n=== Library Catalog ===");
        if (genreCatalog.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        
        for (Map.Entry<String, LinkedList<Book>> entry : genreCatalog.entrySet()) {
            System.out.println("\n" + entry.getKey().toUpperCase() + ":");
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book);
            }
        }
        System.out.println("=======================\n");
    }
    
    public void searchByGenre(String genre) {
        if (!genreCatalog.containsKey(genre)) {
            System.out.println("No books found in genre: " + genre);
            return;
        }
        
        System.out.println("\nBooks in " + genre + ":");
        for (Book book : genreCatalog.get(genre)) {
            System.out.println("  - " + book);
        }
    }
    
    public void searchByAuthor(String author) {
        System.out.println("\nBooks by " + author + ":");
        boolean found = false;
        
        for (LinkedList<Book> books : genreCatalog.values()) {
            for (Book book : books) {
                if (book.author.equalsIgnoreCase(author)) {
                    System.out.println("  - " + book);
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("  No books found by " + author);
        }
    }
    
    public static void main(String[] args) {
        BookShelf library = new BookShelf();
        
        // Add books
        library.addBook("Fiction", new Book("1984", "George Orwell", "978-0451524935"));
        library.addBook("Fiction", new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        library.addBook("Science", new Book("A Brief History of Time", "Stephen Hawking", "978-0553380163"));
        library.addBook("Programming", new Book("Clean Code", "Robert Martin", "978-0132350884"));
        library.addBook("Programming", new Book("Java: The Complete Reference", "Herbert Schildt", "978-1260440232"));
        
        // Try to add duplicate
        library.addBook("Fiction", new Book("1984", "George Orwell", "978-0451524935"));
        
        library.displayCatalog();
        
        // Search operations
        library.searchByGenre("Programming");
        library.searchByAuthor("George Orwell");
        
        // Borrow books
        library.borrowBook("Fiction", "978-0451524935");
        library.borrowBook("Programming", "978-0132350884");
        
        library.displayCatalog();
        
        // Return book
        library.returnBook("Fiction", new Book("Animal Farm", "George Orwell", "978-0451526342"));
        
        library.displayCatalog();
    }
}