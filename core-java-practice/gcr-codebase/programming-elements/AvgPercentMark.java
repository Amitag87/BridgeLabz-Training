public class AvgPercentMark {
    public static void main(String[] args) {
        int mathsMark = 55;


        int scienceMark = 15;

        int englishMark = 30;

        int totalMarks = mathsMark + scienceMark + englishMark;


        double avgMarks = totalMarks / 3.0;


        double percentage = (totalMarks / 300.0) * 100;

        System.out.println("Total Marks: " + totalMarks);


        System.out.println("Average Marks: " + avgMarks);



        
        System.out.println("Percentage: " + percentage + "%");
    }
}

