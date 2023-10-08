class Solution {
    public int numOfArrays(int n, int m, int k) {
        long dp[][][] = new long[n][k + 1][m + 1]; // for dp[i][j][r] - After the I-th number, having j cost in the algorithem, last biggest is r
        int sum = 0, mod = 1000000007;
        for (int i = 0; i< n; i++){
            if (i == 0)  {
                Arrays.fill(dp[0][1],1); 
                continue;
            }
            for (int j = 1; j <= k; j++){
                for (int r = 1; r <= m; r++){
                    dp[i][j][r] = (dp[i - 1][j][r] * r) % mod; // search cost stay as the same last number * r options to choose current number
                    if (j > 1){
                        for (int lastR = 1; lastR < r; lastR++)
                            dp[i][j][r] = (dp[i][j][r] + dp[i - 1][j - 1][lastR]) % mod; // search cost increased by 1       
                    }
                }
            }
        }
        for (int r = 1; r <= m; r++) sum = (sum + (int)dp[n - 1][k][r]) % mod;
        return sum;
    }
}