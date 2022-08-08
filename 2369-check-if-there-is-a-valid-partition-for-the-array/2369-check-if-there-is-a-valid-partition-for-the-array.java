class Solution {
    public boolean part(int[] nums, int i, int[] dp){
        if(i>nums.length-1)
            return true;
        
        if(i>nums.length-2)
            return false;
        if(dp[i] != -1){
            if(dp[i] == 1)
                return true;
            else 
                return false;
        }
        int x1 = nums[i];
        int x2 = nums[i+1];
        int x3 = -1;
        if(i<nums.length - 2)
            x3 = nums[i+2];
        boolean t1 = false, t2 = false, t3 = false;
        if(x1 == x2){
            t1 = part(nums, i+2, dp);
        }
        if(x1 == x2 && x2 == x3){
            t2 = part(nums, i+3, dp);
        }
        if(x1+1 == x2 && x2+1 == x3)
            t3 = part(nums, i+3, dp);
        if(t1 || t2 || t3)
            dp[i] = 1;
        else
            dp[i] = 0;
        
        return t1 || t2 || t3;
    }
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return part(nums, 0, dp);
    }
}