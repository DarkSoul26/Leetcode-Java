class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int[][] dp = new int[m][m];
        
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < m ; j++)
                dp[i][j] = -1;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++)
            min = Math.min(min , path(grid , m , 0 , i , dp));
        
        return min;
    }
    
    public int path(int[][] grid , int m , int r , int c , int[][] dp){
        if(c>=m)
            return Integer.MAX_VALUE-10000;
        
        if(dp[r][c] != -1)  return dp[r][c];
        
        if(r == m-1)
            return grid[r][c];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++)
        {
            if(i != c)
            min = Math.min(min , grid[r][c] + path(grid , m , r+1 , i , dp));
        }
        
        return dp[r][c] = min;
    }
}