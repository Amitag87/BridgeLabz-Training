public class InvoiceGenerator {
    
    public static String[] parseInvoice(String input) {
        return input.split(", ");
    }
    
    public static double getTotalAmount(String[] tasks) {
        double total = 0;
        for (String task : tasks) {
            String[] parts = task.split(" - ");
            if (parts.length == 2) {
                String amountStr = parts[1].replace(" INR", "");
                total += Double.parseDouble(amountStr);
            }
        }
        return total;
    }
    
    public static void generateInvoice(String input) {
        System.out.println("=== Freelancer Invoice Generator ===");
        System.out.println("Input: " + input);
        System.out.println();
        
        String[] tasks = parseInvoice(input);
        
        System.out.println("Invoice Details:");
        System.out.println("----------------");
        
        for (int i = 0; i < tasks.length; i++) {
            String[] parts = tasks[i].split(" - ");
            if (parts.length == 2) {
                String taskName = parts[0];
                String amount = parts[1];
                System.out.println((i + 1) + ". " + taskName + " - " + amount);
            }
        }
        
        System.out.println("----------------");
        System.out.println("Total Amount: " + getTotalAmount(tasks) + " INR");
    }
    
    public static void main(String[] args) {
        String invoice1 = "Logo Design - 3000 INR, Web Page - 4500 INR";
        String invoice2 = "Mobile App - 15000 INR, Database Design - 8000 INR, Testing - 5000 INR";
        
        generateInvoice(invoice1);
        System.out.println();
        generateInvoice(invoice2);
    }
}