class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ansMax = nums[0], ansMin = nums[0];
        int maxTillNow = nums[0], minTillNow = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            minTillNow = Math.min(minTillNow+nums[i], nums[i]);
            ansMin = Math.min(minTillNow, ansMin);
            sum+=nums[i];
            
            maxTillNow = Math.max(maxTillNow+nums[i], nums[i]);
            ansMax = Math.max(maxTillNow, ansMax);
        }
        if(sum == ansMin)
            return ansMax;
        // System.out.println(ansMax+" "+ansMin);
        return Math.max(ansMax,sum-ansMin);
    }
}