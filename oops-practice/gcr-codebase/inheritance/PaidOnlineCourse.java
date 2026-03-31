// PaidOnlineCourse extends OnlineCourse (Level 3)
public class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    public double getFinalPrice() {
        return fee - (fee * discount / 100);
    }
    
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
        System.out.println("Final Price: $" + getFinalPrice());
    }
}