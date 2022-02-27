class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
        int y = coinC(coins, amount, dp, coins.length-1);
        if(y == 1e9)
            return -1;
        return y;
    }
    
    public int coinC(int[] coins, int amt, int[][] dp, int n){
        if(n == 0){
           if(amt%coins[0]==0) 
               return amt/coins[0];
           else 
               return (int)1e9;
        }
        if(dp[n][amt] != -1)
            return dp[n][amt];
        int nt = coinC(coins, amt, dp, n-1);
        int t = Integer.MAX_VALUE;
        if(amt>=coins[n])
            t = 1+ coinC(coins, amt-coins[n], dp, n);
        return dp[n][amt] = Math.min(t, nt);
    }
}