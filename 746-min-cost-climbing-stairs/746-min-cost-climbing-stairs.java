class Solution {
    public int minCost(int[] cost, int n, int[] dp){
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        if(n == cost.length)
            return dp[n] = Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
        return dp[n] = cost[n]+Math.min(minCost(cost, n-1, dp), minCost(cost, n-2, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return minCost(cost, n, dp);
    }
}