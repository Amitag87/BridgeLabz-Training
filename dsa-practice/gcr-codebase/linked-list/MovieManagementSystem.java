class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;
    
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                return;
            }
            current = current.next;
        }
    }
    
    public MovieNode searchByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found");
    }
    
    public void displayForward() {
        System.out.println("=== Movies (Forward) ===");
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }
    
    public void displayReverse() {
        System.out.println("=== Movies (Reverse) ===");
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + 
                             ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
    
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        
        mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        mms.addAtBeginning("The Matrix", "Wachowski Sisters", 1999, 8.7);
        
        mms.displayForward();
        mms.displayReverse();
        
        mms.updateRating("Inception", 9.0);
        mms.removeByTitle("The Matrix");
        
        System.out.println("\nAfter updates:");
        mms.displayForward();
    }
}