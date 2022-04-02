class Solution {
    public long count(String a, String b){
        int m = a.length();
        int n = b.length();
        long dp[][] = new long[m + 1][n + 1];
        for (int i = 0; i <= n; ++i)
            dp[0][i] = 0;
        for (int i = 0; i <= m; ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] +
                                   dp[i - 1][j];    
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[m][n];
    }
    public long numberOfWays(String s) {
        return count(s, "101")+count(s, "010");
    }
}