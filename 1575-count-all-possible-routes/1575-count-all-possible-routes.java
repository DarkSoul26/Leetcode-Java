class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel+1];
        long MOD = (long)(1e9 + 7);
        Arrays.fill(dp[finish],1);
        long ans = 0;
        for(int j = 0; j <= fuel; j++) {
            for(int i = 0; i < locations.length; i++) {
                for(int k = 0; k < locations.length; k++) {
                    if(k == i) continue;
                    if(Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % MOD; 
                    }
                }
            }
        }
        return (int)dp[start][fuel];
    }
}