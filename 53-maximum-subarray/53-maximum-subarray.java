class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<sum)
                max = sum;
            if(sum<0)
                sum = 0;
            sum+=nums[i];
        }
        if(max<sum)
            max = sum;
        return max;
    }
}