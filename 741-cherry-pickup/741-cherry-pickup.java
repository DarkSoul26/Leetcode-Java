class Solution {
    public int pickIt(int[][] g, int x1, int y1, int x2, int[][][] dp){
        int y2 = x1+y1-x2;
        if(x1>=g.length || y1>=g[0].length || x2>=g.length || y2>=g.length || g[x1][y1] == -1 || g[x2][y2] == -1)
            return Integer.MIN_VALUE;
        
        if(x1 == g.length-1 && y1 == g.length-1)
            return g[x1][y1];
        if(x2 == g.length-1 && y2 == g.length-1)
            return g[x2][y2];
        
        if(dp[x1][y1][x2] != 0)
            return dp[x1][y1][x2];
        int c = 0;
        if(x1 == x2 && y1 == y2)
            c = g[x1][y1];
        else
            c = g[x1][y1]+g[x2][y2];
        int p1 = pickIt(g, x1+1, y1, x2, dp);
        int p2 = pickIt(g, x1+1, y1, x2+1, dp);
        int p3 = pickIt(g, x1, y1+1, x2, dp);
        int p4 = pickIt(g, x1, y1+1, x2+1, dp);
        
        
        return dp[x1][y1][x2] = c+Math.max(Math.max(p1,p2), Math.max(p3, p4));
        
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid.length][grid.length];
        int ans = pickIt(grid, 0, 0, 0, dp);
        if(ans < 0)
            return 0;
        return ans;
    }
}