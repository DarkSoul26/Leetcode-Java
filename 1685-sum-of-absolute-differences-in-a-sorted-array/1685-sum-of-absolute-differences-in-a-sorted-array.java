import java.util.*;
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int rightSum=0;
        int n=nums.length;
        int result[]= new int[n];
        for(int num : nums){
            rightSum+=num;
        }
         int leftSum=0;
        for(int i =0;i<n;i++){
             result[i]= Math.abs((i)*nums[i] - leftSum ) + Math.abs((rightSum-nums[i])-(n-1-i)*nums[i]);
             leftSum+=nums[i];
             rightSum-=nums[i];
        }
     return result;  
    }
}