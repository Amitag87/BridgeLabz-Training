public class MultipleCatchBlock {
    public static void main(String[] args) {
      try{ 
         int arr1[]={1,2,3,4,5};
         int arr2[]=null;
        int idx=7;
         System.out.println(arr2[idx]);
        System.out.println(arr1[idx]);
       
    }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initialized");
        }
    }
}
