class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][2][3];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int l = 1;l<=2;l++){
                    if(j == 1)
                        dp[i][j][l] = Math.max(-prices[i]+dp[i+1][j-1][l], dp[i+1][j][l]);
                    else
                        dp[i][j][l] = Math.max(prices[i]+dp[i+1][j+1][l-1], dp[i+1][j][l]);
                }
            }
        }
        return dp[0][1][2];
    }
}