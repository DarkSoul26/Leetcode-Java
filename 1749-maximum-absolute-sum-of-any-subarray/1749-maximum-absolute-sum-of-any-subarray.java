class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], nums[i]+max);
            min = Math.min(nums[i], nums[i]+min);
            ans = Math.max(Math.max(Math.abs(min), max), ans);
        }
        return ans;
    }
}