class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int prod = 1;
            for(int j=i;j<n;j++){
                prod*=nums[j];
                if(prod<k) count++;
                else break;
            }
        }
        return count;
    }
}