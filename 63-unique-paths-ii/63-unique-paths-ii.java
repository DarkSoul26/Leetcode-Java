class Solution {
    // public int ans = 0;
    public int handleObs(int[][] ob, int[][] dp, int i, int j, int n, int m){
        if(ob[i][j] == 1)
            return 0;
        if(i == n-1 && j == m-1 && ob[i][j] == 0){
            return 1;
        }
        if(i>n-1 || j>m-1)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x = 0, y = 0;
        if(i<n-1)
            x = handleObs(ob, dp, i+1, j, n, m);
        
        if(j<m-1)
            y = handleObs(ob, dp, i, j+1, n, m);
        return dp[i][j] = x+y;
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int dp1[]: dp)
            Arrays.fill(dp1, -1);
        return handleObs(obstacleGrid, dp, 0, 0, n, m);
        // return ans;
    }
}