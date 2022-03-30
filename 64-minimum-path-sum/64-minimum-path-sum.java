class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        // for(int[] dp1: dp)
        //     Arrays.fill(dp1, -1);
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++)
            dp[i][0] += grid[i][0]+dp[i-1][0];
        for(int i=1;i<m;i++)
            dp[0][i] += grid[0][i]+dp[0][i-1];
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = grid[i][j]+Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n-1][m-1];
    }
}