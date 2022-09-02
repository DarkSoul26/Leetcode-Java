class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(target>sum || sum+target<0)
            return 0;
        int s = (sum+target)/2;
        if((sum+target)%2!=0)
            return 0;
        int[][] dp = new int[nums.length+1][s+1];
        for(int i=0;i<nums.length+1;i++)
            dp[i][0] = 1;
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<s+1;j++){
                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][s];
    }
}