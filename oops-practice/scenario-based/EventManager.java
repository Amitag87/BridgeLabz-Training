import java.util.*;

// Ticket class
class Ticket {
    private String ticketId;
    private String eventName;
    private String category;
    private double price;
    private String seatNumber;
    private boolean isAvailable;
    private Date createdDate;
    
    public Ticket(String ticketId, String eventName, String category, double price, String seatNumber) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.category = category;
        this.price = price;
        this.seatNumber = seatNumber;
        this.isAvailable = true;
        this.createdDate = new Date();
    }
    
    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public String getEventName() { return eventName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getSeatNumber() { return seatNumber; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public Date getCreatedDate() { return createdDate; }
    
    @Override
    public String toString() {
        return String.format("%s | %s | %s | $%.2f | %s", 
                           ticketId, eventName, category, price, seatNumber);
    }
}

// Quick Sort implementation for ticket pricing
class TicketSorter {
    private int comparisons;
    private int swaps;
    
    public TicketSorter() {
        this.comparisons = 0;
        this.swaps = 0;
    }
    
    // Quick Sort by price (ascending)
    public void quickSortByPrice(List<Ticket> tickets, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(tickets, low, high);
            quickSortByPrice(tickets, low, pivotIndex - 1);
            quickSortByPrice(tickets, pivotIndex + 1, high);
        }
    }
    
    private int partition(List<Ticket> tickets, int low, int high) {
        double pivot = tickets.get(high).getPrice();
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            comparisons++;
            if (tickets.get(j).getPrice() <= pivot) {
                i++;
                swap(tickets, i, j);
            }
        }
        
        swap(tickets, i + 1, high);
        return i + 1;
    }
    
    private void swap(List<Ticket> tickets, int i, int j) {
        if (i != j) {
            Ticket temp = tickets.get(i);
            tickets.set(i, tickets.get(j));
            tickets.set(j, temp);
            swaps++;
        }
    }
    
    // Quick Sort by price (descending)
    public void quickSortByPriceDesc(List<Ticket> tickets, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionDesc(tickets, low, high);
            quickSortByPriceDesc(tickets, low, pivotIndex - 1);
            quickSortByPriceDesc(tickets, pivotIndex + 1, high);
        }
    }
    
    private int partitionDesc(List<Ticket> tickets, int low, int high) {
        double pivot = tickets.get(high).getPrice();
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            comparisons++;
            if (tickets.get(j).getPrice() >= pivot) { // Changed to >= for descending
                i++;
                swap(tickets, i, j);
            }
        }
        
        swap(tickets, i + 1, high);
        return i + 1;
    }
    
    public void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }
    
    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
}

// Event class
class Event {
    private String eventId;
    private String eventName;
    private String venue;
    private Date eventDate;
    private List<Ticket> tickets;
    
    public Event(String eventId, String eventName, String venue, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.venue = venue;
        this.eventDate = eventDate;
        this.tickets = new ArrayList<>();
    }
    
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    
    // Getters
    public String getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public String getVenue() { return venue; }
    public Date getEventDate() { return eventDate; }
    public List<Ticket> getTickets() { return tickets; }
}

public class EventManager {
    private List<Event> events;
    private List<Ticket> allTickets;
    private TicketSorter sorter;
    private Random random;
    
    public EventManager() {
        this.events = new ArrayList<>();
        this.allTickets = new ArrayList<>();
        this.sorter = new TicketSorter();
        this.random = new Random();
        initializeSampleData();
    }
    
    private void initializeSampleData() {
        // Create sample events with tickets
        Event concert = new Event("E001", "Rock Concert", "Madison Square Garden", new Date());
        Event sports = new Event("E002", "Basketball Game", "Sports Arena", new Date());
        Event theater = new Event("E003", "Broadway Show", "Theater District", new Date());
        
        // Add tickets with random prices to simulate real-world scenario
        String[] categories = {"VIP", "Premium", "Standard", "Economy"};
        String[] seatPrefixes = {"A", "B", "C", "D", "E"};
        
        int ticketCounter = 1;
        
        // Generate tickets for each event
        for (Event event : Arrays.asList(concert, sports, theater)) {
            for (int i = 0; i < 100; i++) { // 100 tickets per event
                String category = categories[random.nextInt(categories.length)];
                double basePrice = getBasePriceForCategory(category);
                double price = basePrice + (random.nextDouble() * 100); // Add random variation
                
                String seatNumber = seatPrefixes[random.nextInt(seatPrefixes.length)] + 
                                  String.format("%02d", random.nextInt(50) + 1);
                
                String ticketId = "T" + String.format("%04d", ticketCounter++);
                Ticket ticket = new Ticket(ticketId, event.getEventName(), category, price, seatNumber);
                
                event.addTicket(ticket);
                allTickets.add(ticket);
            }
            
            events.add(event);
        }
        
        System.out.println("📊 Generated " + allTickets.size() + " tickets across " + events.size() + " events");
    }
    
    private double getBasePriceForCategory(String category) {
        switch (category) {
            case "VIP": return 200.0;
            case "Premium": return 150.0;
            case "Standard": return 100.0;
            case "Economy": return 50.0;
            default: return 75.0;
        }
    }
    
    public List<Ticket> getCheapestTickets(int count) {
        List<Ticket> availableTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.isAvailable()) {
                availableTickets.add(ticket);
            }
        }
        
        // Sort by price (ascending) using Quick Sort
        sorter.resetCounters();
        long startTime = System.nanoTime();
        
        sorter.quickSortByPrice(availableTickets, 0, availableTickets.size() - 1);
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        
        System.out.println("\\n💰 TOP " + count + " CHEAPEST TICKETS");
        System.out.println("═".repeat(70));
        System.out.printf("Sorted %d tickets in %.2f ms (Comparisons: %d, Swaps: %d)%n", 
                         availableTickets.size(), duration, sorter.getComparisons(), sorter.getSwaps());
        System.out.println();
        
        List<Ticket> result = availableTickets.subList(0, Math.min(count, availableTickets.size()));
        
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%2d. %s%n", (i + 1), result.get(i));
        }
        
        return result;
    }
    
    public List<Ticket> getMostExpensiveTickets(int count) {
        List<Ticket> availableTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.isAvailable()) {
                availableTickets.add(ticket);
            }
        }
        
        // Sort by price (descending) using Quick Sort
        sorter.resetCounters();
        long startTime = System.nanoTime();
        
        sorter.quickSortByPriceDesc(availableTickets, 0, availableTickets.size() - 1);
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("\\n💎 TOP " + count + " MOST EXPENSIVE TICKETS");
        System.out.println("═".repeat(70));
        System.out.printf("Sorted %d tickets in %.2f ms (Comparisons: %d, Swaps: %d)%n", 
                         availableTickets.size(), duration, sorter.getComparisons(), sorter.getSwaps());
        System.out.println();
        
        List<Ticket> result = availableTickets.subList(0, Math.min(count, availableTickets.size()));
        
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%2d. %s%n", (i + 1), result.get(i));
        }
        
        return result;
    }
    
    public void optimizeTicketPricing() {
        System.out.println("\\n🎯 Ticket Price Optimization Analysis");
        System.out.println("═".repeat(50));
        
        // Analyze price distribution
        Map<String, List<Double>> categoryPrices = new HashMap<>();
        
        for (Ticket ticket : allTickets) {
            categoryPrices.computeIfAbsent(ticket.getCategory(), k -> new ArrayList<>())
                         .add(ticket.getPrice());
        }
        
        System.out.println("Price analysis by category:");
        for (Map.Entry<String, List<Double>> entry : categoryPrices.entrySet()) {
            List<Double> prices = entry.getValue();
            double avg = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double min = prices.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
            double max = prices.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
            
            System.out.printf("%-10s: Avg=$%.2f, Min=$%.2f, Max=$%.2f (%d tickets)%n", 
                            entry.getKey(), avg, min, max, prices.size());
        }
    }
    
    public void performanceComparison() {
        System.out.println("\\n⚡ Quick Sort Performance Analysis");
        System.out.println("═".repeat(50));
        
        // Test with different data sizes
        int[] testSizes = {100, 500, 1000};
        
        for (int size : testSizes) {
            List<Ticket> testTickets = new ArrayList<>(allTickets.subList(0, Math.min(size, allTickets.size())));
            
            // Shuffle to simulate random data
            Collections.shuffle(testTickets);
            
            sorter.resetCounters();
            long startTime = System.nanoTime();
            
            sorter.quickSortByPrice(testTickets, 0, testTickets.size() - 1);
            
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("Size: %4d | Time: %6.2f ms | Comparisons: %5d | Swaps: %4d%n", 
                            size, duration, sorter.getComparisons(), sorter.getSwaps());
        }
        
        System.out.println("\\n✅ Quick Sort chosen because:");
        System.out.println("   • Average O(n log n) time complexity");
        System.out.println("   • Excellent for large, unsorted datasets");
        System.out.println("   • In-place sorting (low memory usage)");
        System.out.println("   • Fast average-case performance");
        System.out.println("   • Ideal for price optimization scenarios");
    }
    
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        
        System.out.println("🎫 Event Booking Portal - Ticket Price Optimizer");
        System.out.println("Using Quick Sort for optimal performance with large datasets\\n");
        
        // Get cheapest tickets
        eventManager.getCheapestTickets(10);
        
        // Get most expensive tickets
        eventManager.getMostExpensiveTickets(10);
        
        // Price optimization analysis
        eventManager.optimizeTicketPricing();
        
        // Performance comparison
        eventManager.performanceComparison();
        
        // Simulate booking some tickets
        System.out.println("\\n🎟️ Simulating ticket bookings...");
        List<Ticket> cheapest = eventManager.getCheapestTickets(5);
        
        // Book first 3 cheapest tickets
        for (int i = 0; i < Math.min(3, cheapest.size()); i++) {
            Ticket ticket = cheapest.get(i);
            ticket.setAvailable(false);
            System.out.println("✅ Booked: " + ticket.getTicketId() + " for $" + 
                             String.format("%.2f", ticket.getPrice()));
        }
        
        System.out.println("\\n📊 Updated cheapest available tickets:");
        eventManager.getCheapestTickets(5);
    }
}