class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int con = 1000000007;
        
        long[][] dp = new long[n+1][goal+1];
        
        dp[0][0] = 1;
        dp[1][1] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=goal;j++){
                if(i==j){
                    dp[i][j] = (dp[i-1][j-1]*i)%con;
                } else {
                    dp[i][j] = ((dp[i][j-1]*Math.max(0, i-k))%con + (dp[i-1][j-1]*i)%con)%con; 
                }
            }
        }
        return (int)dp[n][goal];
    }
}