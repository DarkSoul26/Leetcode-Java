class Solution {
    public int paths(int[][] g, int i, int j, int[][] dp, int z){
        // if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)   return 0;
        if(g[i][j] == 2){
            return (z == -1?1:0);
        }
        
        if(g[i][j] == -1)
            return 0;
        int u = 0, d = 0, l = 0, r = 0;
        g[i][j] = -1;
        z--;
        if(i>0)
            u = paths(g, i-1, j, dp, z);
        if(i<g.length-1)
            d = paths(g, i+1, j, dp, z);
        if(j>0)
            l = paths(g, i, j-1, dp, z);
        if(j<g[0].length-1)
            r = paths(g, i, j+1, dp, z);
        
        g[i][j] = 0;
        z++;
        return u+d+l+r;
    }
    public int uniquePathsIII(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] d: dp)
            Arrays.fill(d, -1);
        int x = -1, y = -1, z = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                if(grid[i][j] == 0)
                    z++;
            }
        }
        return paths(grid, x, y, dp, z);
    }
}