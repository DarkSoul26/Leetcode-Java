class Solution {
    
    public int robMe(int[] a, int i, int dp[]){
        if(i>=a.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i]=Math.max(robMe(a,i+1,dp),robMe(a,i+2,dp)+a[i]);
        return dp[i];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robMe(nums, 0, dp);
    }
}