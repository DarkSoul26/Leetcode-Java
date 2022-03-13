class Solution {
    
    public int robMe(int[] a, int i, int dp[]){
        if(i>=a.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        // int robIt = 0, dontRob = 0;
        // dontRob = robMe(a, i+1, false, dp);
        // if(!adjRob)
        //     robIt = a[i]+robMe(a, i+1, true, dp);
        dp[i]=Math.max(robMe(a,i+1,dp),robMe(a,i+2,dp)+a[i]);
        return dp[i];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robMe(nums, 0, dp);
    }
}