public class NormalFare implements FareCalculator {
    private static final double RATE_PER_KM = 10.0;
    private static final double BASE_FARE = 20.0;
    
    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE_PER_KM);
    }
    
    @Override
    public String getFareType() {
        return "Normal";
    }
}