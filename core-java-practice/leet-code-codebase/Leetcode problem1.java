class TwoSum{
    public static void main(String[] args){
      int nums[4]={3,4,5,6};
      int target=4;
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int req=target-nums[i];
        if(map.containsKey(req)){
            
            System.out.println(map.get(req));
        }
        map.put(nums[i],i);
      }
}