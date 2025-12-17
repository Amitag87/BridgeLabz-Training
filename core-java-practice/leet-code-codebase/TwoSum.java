import  java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int target=2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int req=target-arr[i];
            if(map.containsKey(req)){
                System.out.println(map.get(req));
            }
            map.put(arr[i],i);
        }
    }

}
