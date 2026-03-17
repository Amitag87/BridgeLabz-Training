import java.util.*;

class Booking {
    String passengerId;
    int seatCount;
    int fare;

    Booking(String passengerId, int seatCount, int fare) {
        this.passengerId = passengerId;
        this.seatCount = seatCount;
        this.fare = fare;
    }
}

class Train {
    String trainId, source, destination;
    int totalSeats, baseFare, availableSeats;
    List<Booking> bookings = new ArrayList<>();

    Train(String id, String src, String dest, int seats, int fare) {
        trainId = id;
        source = src;
        destination = dest;
        totalSeats = seats;
        baseFare = fare;
        availableSeats = seats;
    }
}

class RailwayManager {

    List<Train> trains = new ArrayList<>();

    // ADD TRAIN
    public void addTrain(String id, String src, String dest, int seats, int fare) {
        for (Train t : trains) {
            if (t.trainId.equals(id)) return;
        }
        trains.add(new Train(id, src, dest, seats, fare));
    }

    // BOOK
    public void book(String id, String pid, int seatCount) {
        for (Train t : trains) {
            if (t.trainId.equals(id)) {

                if (seatCount > t.availableSeats) {
                    System.out.println("Booking failed");
                    return;
                }

                int fare = seatCount * t.baseFare + seatCount * 25;

                t.availableSeats -= seatCount;
                t.bookings.add(new Booking(pid, seatCount, fare));

                System.out.println("BOOKED " + id + " " + pid + " " + fare);
                return;
            }
        }
        System.out.println("Booking failed");
    }

    // CANCEL
    public void cancel(String id, String pid) {
        for (Train t : trains) {
            if (t.trainId.equals(id)) {

                Iterator<Booking> it = t.bookings.iterator();
                while (it.hasNext()) {
                    Booking b = it.next();

                    if (b.passengerId.equals(pid)) {
                        t.availableSeats += b.seatCount;
                        it.remove();

                        System.out.println("CANCELLED " + id + " " + pid);
                        return;
                    }
                }
                System.out.println("Cancellation failed");
                return;
            }
        }
        System.out.println("Cancellation failed");
    }

    // ROUTE
    public void route(String src, String dest) {
        boolean found = false;

        for (Train t : trains) {
            if (t.source.equals(src) && t.destination.equals(dest)) {
                System.out.println(t.trainId + " " + t.availableSeats);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains available");
        }
    }

    // SUMMARY
    public void summary() {
        boolean hasRevenue = false;

        for (Train t : trains) {
            int total = 0;
            for (Booking b : t.bookings) {
                total += b.fare;
            }

            if (total > 0) hasRevenue = true;

            System.out.println(t.trainId + " " + total);
        }

        if (!hasRevenue) {
            System.out.println("No revenue generated");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        RailwayManager rm = new RailwayManager();

        while (n-- > 0) {
            String line = sc.nextLine().trim();
            String[] p = line.split(" ");

            switch (p[0]) {

                case "ADDTRAIN":
                    rm.addTrain(p[1], p[2], p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]));
                    break;

                case "BOOK":
                    rm.book(p[1], p[2], Integer.parseInt(p[3]));
                    break;

                case "CANCEL":
                    rm.cancel(p[1], p[2]);
                    break;

                case "ROUTE":
                    rm.route(p[1], p[2]);
                    break;

                case "SUMMARY":
                    rm.summary();
                    break;
            }
        }
    }
}