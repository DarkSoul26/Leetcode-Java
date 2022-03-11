class Solution {
    
    public int findTrib(int n, int dp[]){
        if(n == 0)
            return dp[n] = 0;
        if(n == 1 || n == 2)
            return dp[n] = 1;
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n] = findTrib(n-1, dp)+findTrib(n-2, dp)+findTrib(n-3, dp);
    }
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return findTrib(n, dp);
    }
}