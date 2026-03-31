public class TemperatureAnalyzer {
    
    public static void analyzeTemperature(float[][] temperatures) {
        if (temperatures == null || temperatures.length != 7) {
            System.out.println("Invalid temperature data");
            return;
        }
        
        float hottestTemp = Float.MIN_VALUE;
        float coldestTemp = Float.MAX_VALUE;
        int hottestDay = 0, coldestDay = 0;
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        for (int day = 0; day < 7; day++) {
            float daySum = 0;
            
            for (int hour = 0; hour < 24; hour++) {
                float temp = temperatures[day][hour];
                daySum += temp;
                
                if (temp > hottestTemp) {
                    hottestTemp = temp;
                    hottestDay = day;
                }
                
                if (temp < coldestTemp) {
                    coldestTemp = temp;
                    coldestDay = day;
                }
            }
            
            float dayAverage = daySum / 24;
            System.out.printf("%s average temperature: %.2f°C%n", days[day], dayAverage);
        }
        
        System.out.printf("Hottest day: %s (%.2f°C)%n", days[hottestDay], hottestTemp);
        System.out.printf("Coldest day: %s (%.2f°C)%n", days[coldestDay], coldestTemp);
    }
    
    public static void main(String[] args) {
        // Sample temperature data for a week (7 days x 24 hours)
        float[][] temperatures = new float[7][24];
        
        // Fill with sample data
        for (int day = 0; day < 7; day++) {
            for (int hour = 0; hour < 24; hour++) {
                temperatures[day][hour] = 15 + (float)(Math.random() * 20); // 15-35°C range
            }
        }
        
        // Add some extreme values for testing
        temperatures[2][14] = 38.5f; // Hottest
        temperatures[5][4] = 8.2f;   // Coldest
        
        analyzeTemperature(temperatures);
    }
}