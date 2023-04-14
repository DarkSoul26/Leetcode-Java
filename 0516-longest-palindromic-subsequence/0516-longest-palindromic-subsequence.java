class Solution {
    public int longestPalindromeSubseq(String s1) {
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}