class Solution {
    
    public int findFibo(int n, int dp[]){
        if(n == 0 || n == 1)
            return dp[n] = n;
        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n] = findFibo(n-1, dp)+findFibo(n-2, dp);
    }
    
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return findFibo(n, dp);
    }
}