public class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}
public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!(flightName.equalsIgnoreCase("SpiceJet")
                || flightName.equalsIgnoreCase("Vistara")
                || flightName.equalsIgnoreCase("IndiGo")
                || flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity;

        if (flightName.equalsIgnoreCase("SpiceJet")) {
            maxCapacity = 396;
        } else if (flightName.equalsIgnoreCase("Vistara")) {
            maxCapacity = 615;
        } else if (flightName.equalsIgnoreCase("IndiGo")) {
            maxCapacity = 230;
        } else { // Air Arabia
            maxCapacity = 130;
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuel;

        if (flightName.equalsIgnoreCase("SpiceJet")) {
            maxFuel = 200000;
        } else if (flightName.equalsIgnoreCase("Vistara")) {
            maxFuel = 300000;
        } else if (flightName.equalsIgnoreCase("IndiGo")) {
            maxFuel = 250000;
        } else { // Air Arabia
            maxFuel = 150000;
        }

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return maxFuel - currentFuelLevel;
    }
}

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        try {
            System.out.println("Enter flight details");
            String input = scanner.nextLine();

            String[] details = input.split(":");

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double currentFuelLevel = Double.parseDouble(details[3]);

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelRequired =
                    flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handles parsing or unexpected runtime errors safely
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}