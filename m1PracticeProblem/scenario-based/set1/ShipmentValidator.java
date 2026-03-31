import java.util.*;

public class ShipmentValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String record = sc.nextLine();

            if (isValid(record)) {
                System.out.println("COMPLIANT RECORD");
            } else {
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }

    static boolean isValid(String record) {
        String[] parts = record.split("\\|");
        if (parts.length != 5) return false;

        return isValidCode(parts[0]) &&
               isValidDate(parts[1]) &&
               isValidMode(parts[2]) &&
               isValidWeight(parts[3]) &&
               isValidStatus(parts[4]);
    }

    // 1️⃣ Shipment Code
    static boolean isValidCode(String code) {
        if (!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String digits = code.substring(5);

        int count = 1;
        for (int i = 1; i < digits.length(); i++) {
            if (digits.charAt(i) == digits.charAt(i - 1)) {
                count++;
                if (count > 3) return false;
            } else {
                count = 1;
            }
        }
        return true;
    }

    // 2️⃣ Date Validation
    static boolean isValidDate(String date) {
        if (!date.matches("20\\d{2}-\\d{2}-\\d{2}")) return false;

        String[] d = date.split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        if (month < 1 || month > 12) return false;

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        // Leap year check
        if (isLeap(year)) days[1] = 29;

        return day >= 1 && day <= days[month - 1];
    }

    static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // 3️⃣ Mode
    static boolean isValidMode(String mode) {
        return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
    }

    // 4️⃣ Weight
    static boolean isValidWeight(String w) {
        if (!w.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?")) return false;

        double val = Double.parseDouble(w);
        return val > 0 && val <= 999999.99;
    }

    // 5️⃣ Status
    static boolean isValidStatus(String s) {
        return s.matches("DELIVERED|CANCELLED|IN_TRANSIT");
    }
}