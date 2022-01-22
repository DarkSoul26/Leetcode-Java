class Solution {
    boolean dp[] = new boolean[100001];
    public boolean helpUs(int n){
        if(n<=0) return false;
        if(dp[n]!=false) return dp[n];
        for(int i=1;i*i<=n;i++)
            if(!helpUs(n-i*i))
                return dp[n] = true;
        return dp[n] = false;
    }
    public boolean winnerSquareGame(int n) {
        return helpUs(n);
    }
}