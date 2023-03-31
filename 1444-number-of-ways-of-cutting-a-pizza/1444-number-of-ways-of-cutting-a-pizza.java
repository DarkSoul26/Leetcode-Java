class Solution {
    final int MOD = (int) 1e9+7;
    int m, n, k;
    int[][] sums;
    Integer[][][] dp;
    
    public int ways(String[] pizza, int k) {
        this.k = k;
        m = pizza.length; 
        n = pizza[0].length();
        sums = new int[m+1][n+1];
        for (int i = m-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--)
                sums[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) 
                                + sums[i+1][j] + sums[i][j+1] - sums[i+1][j+1];
        dp = new Integer[m][n][k+1];
        return wayRec(0, 0, 1);
    }
    
    private int wayRec(int i, int j, int v) {
        if (dp[i][j][v] != null) return dp[i][j][v];
        if (v == k) return dp[i][j][v] = (sums[i][j] > 0 ? 1 : 0);
        int ret = 0;
        for (int r = i; r < m-1; r++) 
            if (sums[i][j] - sums[r+1][j] > 0) ret = (ret + wayRec(r+1, j, v+1)) % MOD;
        for (int c = j; c < n-1; c++)
            if (sums[i][j] - sums[i][c+1] > 0) ret = (ret + wayRec(i, c+1, v+1)) % MOD;
        return dp[i][j][v] = ret;
    }
}