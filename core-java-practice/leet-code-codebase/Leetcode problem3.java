class Solution {
    public static void main(String args[]){
	int nums[3]={1,2,3};
	int nums[4]={2,3,4};
        int n1=nums1.length , n2=nums2.length;
        int[] nums=new int[n1+n2]; int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums[k]=nums1[i]; i++;
            }
            else{
                nums[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            nums[k]=nums1[i];
            i++;k++;
        }
        while(j<nums2.length){
            nums[k]=nums2[j];
            j++;k++;
        }
        double result=0;
        if(nums.length%2==0){
             result=(nums[nums.length/2]+nums[(nums.length/2)-1])/2.0;
        }
        else{
            result=nums[nums.length/2];
        }
	System.out.print(result);
    }
}