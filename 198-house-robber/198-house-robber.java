class Solution {
    
    public int maxProf(int[] a, int ind, int dp[]){
        if(ind <= 0)
            return 0;
        if(dp[ind-1]!=-1)
            return dp[ind-1];
        dp[ind-1]=Math.max(maxProf(a,ind-1,dp),maxProf(a,ind-2,dp)+a[ind-1]);
        return dp[ind-1];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return maxProf(nums, nums.length, dp);
    }
}