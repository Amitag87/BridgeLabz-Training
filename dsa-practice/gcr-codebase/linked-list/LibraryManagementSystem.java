class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    
    public BookNode(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = true;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;
    private int totalBooks = 0;
    
    public void addBook(String title, String author, String genre, int bookId) {
        BookNode newNode = new BookNode(title, author, genre, bookId);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
    }
    
    public void removeBook(int bookId) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                totalBooks--;
                return;
            }
            current = current.next;
        }
    }
    
    public BookNode searchByTitle(String title) {
        BookNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public BookNode searchByAuthor(String author) {
        BookNode current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void updateAvailability(int bookId, boolean status) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }
    
    public void displayForward() {
        System.out.println("=== Library Books (Forward) ===");
        BookNode current = head;
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title + 
                             ", Author: " + current.author + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }
    
    public void displayReverse() {
        System.out.println("=== Library Books (Reverse) ===");
        BookNode current = tail;
        while (current != null) {
            System.out.println("ID: " + current.bookId + ", Title: " + current.title + 
                             ", Author: " + current.author + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }
    
    public int getTotalBooks() {
        return totalBooks;
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        
        lms.addBook("Java Programming", "John Smith", "Programming", 101);
        lms.addBook("Data Structures", "Jane Doe", "Computer Science", 102);
        lms.addBook("Algorithms", "Bob Johnson", "Computer Science", 103);
        
        lms.displayForward();
        System.out.println("Total Books: " + lms.getTotalBooks());
        
        lms.updateAvailability(102, false);
        lms.removeBook(103);
        
        System.out.println("\nAfter updates:");
        lms.displayReverse();
        System.out.println("Total Books: " + lms.getTotalBooks());
    }
}