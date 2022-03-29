class Solution {
    public String longestPalindrome(String s1) {
        StringBuffer sb1 = new StringBuffer(s1);
        String s2 = sb1.reverse().toString();
        int n = s1.length();
        int dp[][] = new int[n+1][n+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;
        int prevBest = Integer.MIN_VALUE;
        String str = "";
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(dp[i][j]>prevBest){
                        if(isPali(s1.substring(i-dp[i][j], i))){
                            str = s1.substring(i-dp[i][j], i);
                            prevBest = dp[i][j];
                        }
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return str;
    }
    
    public boolean isPali(String s){
        for(int i=0,j=s.length()-1;(i<=s.length()/2 && j>=s.length()/2);i++,j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }
}