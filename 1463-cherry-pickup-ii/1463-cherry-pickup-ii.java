class Solution {
    Integer dp[][][];
    int n;
    int m;
    public int pickIt(int[][] g, int x1, int y1, int y2){
        if(x1 == n)
            return 0;
        if(x1>=n || y1>=m || y2>=m || x1<0 || y1<0 || y2<0)
            return 0;
        if(dp[x1][y1][y2] != null)
            return dp[x1][y1][y2];
    
        int max = Integer.MIN_VALUE;
        for(int m1=-1; m1<=1; m1++)
            for(int m2=-1; m2<=1; m2++)
                max = Math.max(max, pickIt(g, x1+1, y1+m1, y2+m2));
        int c = y1 == y2?g[x1][y1]:g[x1][y1]+g[x1][y2];
        return dp[x1][y1][y2] = c+max;
        
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][m];
        return pickIt(grid, 0, 0, m-1);
    }
}