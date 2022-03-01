class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
         return findPaths(m,n,dp);
    }
    
    public int findPaths(int m, int n, int dp[][]){
        if(m == 1 && n == 1)
            return dp[m][n] = 1;
        if(m == 0 || n == 0)
            return 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        dp[m][n] = findPaths(m-1,n,dp)+findPaths(m,n-1,dp);
        return dp[m][n];
    }
}