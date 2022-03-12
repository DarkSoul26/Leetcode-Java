class Solution {
    public int minInsertions(String s1) {
        int n = s1.length();
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        int dp[][] = new int[n+1][n+1];
        for(int[] dp1: dp)
          Arrays.fill(dp1, -1);
          
        for(int i=0;i<=n;i++){
          dp[i][0] = 0;
          dp[0][i] = 0;
        }
        
        for(int i=1;i<=n;i++){
          for(int j=1;j<=n;j++){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
              dp[i][j] = 1+dp[i-1][j-1];
            }
            else{
              dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
          }
        }
        
        return n-dp[n][n];
    }
}