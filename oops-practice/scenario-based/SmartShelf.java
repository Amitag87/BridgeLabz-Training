import java.util.*;

// Book class
class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private Date addedDate;
    
    public Book(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.addedDate = new Date();
    }
    
    // Getters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public Date getAddedDate() { return addedDate; }
    
    @Override
    public String toString() {
        return title + " by " + author;
    }
}

// Reading List with Insertion Sort
class ReadingList {
    private List<Book> books;
    private String listName;
    private int sortComparisons;
    private int sortSwaps;
    
    public ReadingList(String listName) {
        this.listName = listName;
        this.books = new ArrayList<>();
        this.sortComparisons = 0;
        this.sortSwaps = 0;
    }
    
    // Real-time insertion with sorting
    public void addBook(Book book) {
        books.add(book);
        
        // Perform insertion sort on the newly added book
        insertionSortRealTime(books.size() - 1);
        
        System.out.println("📚 Added: " + book.getTitle() + " (List sorted alphabetically)");
    }
    
    // Optimized insertion sort for real-time additions
    private void insertionSortRealTime(int newBookIndex) {
        Book newBook = books.get(newBookIndex);
        int position = newBookIndex;
        
        // Move the new book to its correct position
        while (position > 0) {
            sortComparisons++;
            Book previousBook = books.get(position - 1);
            
            if (newBook.getTitle().compareToIgnoreCase(previousBook.getTitle()) >= 0) {
                break; // Found correct position
            }
            
            // Shift book to the right
            books.set(position, previousBook);
            position--;
            sortSwaps++;
        }
        
        // Place the new book in its correct position
        books.set(position, newBook);
        
        if (position != newBookIndex) {
            System.out.println("   📍 Moved '" + newBook.getTitle() + "' to position " + (position + 1));
        }
    }
    
    // Complete insertion sort (for initial sorting or verification)
    public void fullInsertionSort() {
        sortComparisons = 0;
        sortSwaps = 0;
        
        for (int i = 1; i < books.size(); i++) {
            Book currentBook = books.get(i);
            int j = i - 1;
            
            while (j >= 0) {
                sortComparisons++;
                if (books.get(j).getTitle().compareToIgnoreCase(currentBook.getTitle()) <= 0) {
                    break;
                }
                
                books.set(j + 1, books.get(j));
                j--;
                sortSwaps++;
            }
            
            books.set(j + 1, currentBook);
        }
        
        System.out.println("Full sort completed - Comparisons: " + sortComparisons + ", Swaps: " + sortSwaps);
    }
    
    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book removedBook = books.remove(i);
                System.out.println("📤 Removed: " + removedBook.getTitle());
                return true;
            }
        }
        System.out.println("❌ Book not found: " + title);
        return false;
    }
    
    public void displayList() {
        System.out.println("\\n📖 " + listName + " (" + books.size() + " books):");
        System.out.println("═".repeat(50));
        
        if (books.isEmpty()) {
            System.out.println("   (Empty reading list)");
        } else {
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                System.out.printf("%2d. %-30s by %s%n", 
                                (i + 1), book.getTitle(), book.getAuthor());
            }
        }
        System.out.println();
    }
    
    public void searchBook(String searchTerm) {
        System.out.println("🔍 Searching for: " + searchTerm);
        List<Book> results = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(book);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("   No books found matching '" + searchTerm + "'");
        } else {
            System.out.println("   Found " + results.size() + " book(s):");
            for (Book book : results) {
                System.out.println("   • " + book);
            }
        }
    }
    
    public void getStatistics() {
        System.out.println("\\n📊 Reading List Statistics:");
        System.out.println("Total books: " + books.size());
        System.out.println("Sort comparisons (session): " + sortComparisons);
        System.out.println("Sort swaps (session): " + sortSwaps);
        
        // Genre distribution
        Map<String, Integer> genreCount = new HashMap<>();
        for (Book book : books) {
            genreCount.put(book.getGenre(), genreCount.getOrDefault(book.getGenre(), 0) + 1);
        }
        
        if (!genreCount.isEmpty()) {
            System.out.println("Genre distribution:");
            for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
                System.out.println("   " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
    public boolean isSorted() {
        for (int i = 1; i < books.size(); i++) {
            if (books.get(i - 1).getTitle().compareToIgnoreCase(books.get(i).getTitle()) > 0) {
                return false;
            }
        }
        return true;
    }
    
    public int getSize() {
        return books.size();
    }
}

public class SmartShelf {
    private ReadingList readingList;
    private Scanner scanner;
    
    public SmartShelf() {
        this.readingList = new ReadingList("My Digital Reading List");
        this.scanner = new Scanner(System.in);
    }
    
    public void demonstrateRealTimeSorting() {
        System.out.println("🏛️ Digital Library Kiosk - Smart Shelf System");
        System.out.println("Real-time alphabetical sorting using Insertion Sort\\n");
        
        // Demonstrate real-time sorting with sample books
        Book[] sampleBooks = {
            new Book("978-0134685991", "Effective Java", "Joshua Bloch", "Programming"),
            new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman", "Programming"),
            new Book("978-0132350884", "Clean Code", "Robert Martin", "Programming"),
            new Book("978-0201633610", "Design Patterns", "Gang of Four", "Programming"),
            new Book("978-0134494166", "Clean Architecture", "Robert Martin", "Programming"),
            new Book("978-0321125215", "Domain-Driven Design", "Eric Evans", "Programming"),
            new Book("978-0137081073", "The Clean Coder", "Robert Martin", "Programming"),
            new Book("978-0596007126", "Head First Java", "Kathy Sierra", "Programming")
        };
        
        System.out.println("📚 Adding books one by one (demonstrating real-time sorting):");
        System.out.println("═".repeat(70));
        
        for (Book book : sampleBooks) {
            readingList.addBook(book);
            
            // Show current state after each addition
            if (readingList.getSize() <= 5) {
                readingList.displayList();
            } else {
                System.out.println("   Current list size: " + readingList.getSize() + " books (sorted)");
            }
            
            // Verify sorting
            if (!readingList.isSorted()) {
                System.out.println("⚠️ WARNING: List is not properly sorted!");
            }
            
            // Small delay for demonstration
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Final display
        readingList.displayList();
        readingList.getStatistics();
    }
    
    public void interactiveMode() {
        System.out.println("\\n🎮 Interactive Mode - Add your own books!");
        System.out.println("Commands: add, remove, search, display, stats, quit");
        
        while (true) {
            System.out.print("\\n> ");
            String command = scanner.nextLine().trim().toLowerCase();
            
            switch (command) {
                case "add":
                    addBookInteractive();
                    break;
                case "remove":
                    removeBookInteractive();
                    break;
                case "search":
                    searchBookInteractive();
                    break;
                case "display":
                    readingList.displayList();
                    break;
                case "stats":
                    readingList.getStatistics();
                    break;
                case "quit":
                    System.out.println("👋 Thank you for using Smart Shelf!");
                    return;
                default:
                    System.out.println("Unknown command. Try: add, remove, search, display, stats, quit");
            }
        }
    }
    
    private void addBookInteractive() {
        System.out.print("Book title: ");
        String title = scanner.nextLine().trim();
        
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();
        
        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        
        if (!title.isEmpty() && !author.isEmpty()) {
            String isbn = "978-" + System.currentTimeMillis(); // Generate dummy ISBN
            Book book = new Book(isbn, title, author, genre.isEmpty() ? "General" : genre);
            readingList.addBook(book);
        } else {
            System.out.println("❌ Title and author are required!");
        }
    }
    
    private void removeBookInteractive() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine().trim();
        readingList.removeBook(title);
    }
    
    private void searchBookInteractive() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().trim();
        readingList.searchBook(searchTerm);
    }
    
    public void performanceTest() {
        System.out.println("\\n⚡ Performance Test - Insertion Sort Efficiency");
        System.out.println("Testing with different data scenarios:\\n");
        
        // Test 1: Already sorted data
        ReadingList sortedList = new ReadingList("Pre-sorted Books");
        String[] sortedTitles = {"A Book", "B Book", "C Book", "D Book", "E Book"};
        
        System.out.println("Test 1: Adding to already sorted list (best case)");
        for (String title : sortedTitles) {
            Book book = new Book("isbn", title, "Author", "Test");
            sortedList.addBook(book);
        }
        sortedList.getStatistics();
        
        // Test 2: Reverse sorted data
        ReadingList reverseList = new ReadingList("Reverse-sorted Books");
        String[] reverseTitles = {"Z Book", "Y Book", "X Book", "W Book", "V Book"};
        
        System.out.println("\\nTest 2: Adding in reverse order (worst case)");
        for (String title : reverseTitles) {
            Book book = new Book("isbn", title, "Author", "Test");
            reverseList.addBook(book);
        }
        reverseList.getStatistics();
        
        System.out.println("\\n✅ Insertion Sort is ideal for this use case because:");
        System.out.println("   • Efficient for small datasets");
        System.out.println("   • Excellent for nearly sorted data");
        System.out.println("   • Stable sorting (maintains relative order)");
        System.out.println("   • Online algorithm (sorts as data arrives)");
        System.out.println("   • Low memory overhead");
    }
    
    public static void main(String[] args) {
        SmartShelf smartShelf = new SmartShelf();
        
        // Demonstrate real-time sorting
        smartShelf.demonstrateRealTimeSorting();
        
        // Performance analysis
        smartShelf.performanceTest();
        
        // Interactive mode (commented out for demo)
        // smartShelf.interactiveMode();
    }
}