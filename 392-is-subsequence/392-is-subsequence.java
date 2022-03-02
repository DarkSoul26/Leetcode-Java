class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(n == 0)
            return true;
        if(m == 0)
            return false;
        int dp[][] = new int[n+1][m+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
        lcs(s, t, n, m, dp);
        // System.out.println(dp[n][m]);
        if(dp[n][m]-1 == s.length())
            return true;
        else 
            return false;
        
    }
    
    public int lcs(String s, String t, int n, int m, int[][] dp){
        if(n == 0)
            return 1;
        if(m==0)
            return 0;
        
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        if(s.charAt(n-1) == t.charAt(m-1))
            dp[n][m] = 1+lcs(s, t, n-1, m-1, dp);
        else
            dp[n][m] = lcs(s, t, n, m-1, dp);
        return dp[n][m];
    }
}