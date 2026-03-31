public class BubbleSort_SortStudentMarks {
    public static void main(String[] args) {
        int marks[]={30,40,20,10,50};
        int n=marks.length;
        System.out.println("Student Marks before Sorting: ");
        for(int studentMarks: marks){
            System.out.println(studentMarks);
        }
        System.out.println("Student Marks after Sorting: ");
        bubbleSort(marks,n);
        for(int studentMarks: marks){
            System.out.println(studentMarks);
        }
    }
    public static void bubbleSort(int marks[],int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(marks[j]>marks[j+1]){
                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                }
            }
        }
    }
}