import java.util.*;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class CinemaTime {
    private List<String> movieTitles;
    private List<String> movieTimes;
    
    public CinemaTime() {
        this.movieTitles = new ArrayList<>();
        this.movieTimes = new ArrayList<>();
    }
    
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTimeFormat(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
        System.out.println("Added: " + title + " at " + time);
    }
    
    private boolean isValidTimeFormat(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours <= 23 && minutes <= 59;
    }
    
    public void searchMovie(String keyword) {
        System.out.println("\\nSearching for: " + keyword);
        boolean found = false;
        
        for (int i = 0; i < movieTitles.size(); i++) {
            try {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    String result = String.format("%s - %s", movieTitles.get(i), movieTimes.get(i));
                    System.out.println(result);
                    found = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index " + i);
            }
        }
        
        if (!found) {
            System.out.println("No movies found with keyword: " + keyword);
        }
    }
    
    public void displayAllMovies() {
        System.out.println("\\n=== All Movies ===");
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled");
            return;
        }
        
        for (int i = 0; i < movieTitles.size(); i++) {
            try {
                String movie = (i + 1) + ". " + movieTitles.get(i) + " - " + movieTimes.get(i);
                System.out.println(movie);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error accessing movie at index " + i);
            }
        }
    }
    
    public String[] generateReport() {
        String[] report = new String[movieTitles.size()];
        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = String.format("%-25s | %s", movieTitles.get(i), movieTimes.get(i));
        }
        return report;
    }
    
    public void printReport() {
        System.out.println("\\n=== Cinema Report ===");
        String[] report = generateReport();
        
        for (String line : report) {
            System.out.println(line);
        }
    }
    
    public static void main(String[] args) {
        CinemaTime cinema = new CinemaTime();
        
        try {
            cinema.addMovie("Avengers", "14:30");
            cinema.addMovie("Spider-Man", "17:45");
            cinema.addMovie("Batman", "20:15");
            
            cinema.displayAllMovies();
            
            cinema.searchMovie("Spider");
            cinema.searchMovie("Superman");
            
            cinema.printReport();
            
            // Test invalid time
            cinema.addMovie("Invalid Movie", "25:99");
            
        } catch (InvalidTimeFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}