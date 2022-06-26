class Solution {
    long m = 1000000007;
    int countHousePlacements(int n) {
        long[] dp = new long[n+5];
        dp[1] = 2;
        dp[2] = 3;
        
        for(int i=3; i<=n; i++) dp[i] = (dp[i-1] + dp[i-2]) % m;
        long x = (dp[n] * dp[n]) % m;
        return (int)x;
    }
}