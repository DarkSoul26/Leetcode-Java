class Solution {
    
    public int dropIt(int k, int n, int dp[][]){
        if(k == 1 || n == 0 || n == 1)
            return dp[k][n] = n;
        
        if(dp[k][n]!=-1)
            return dp[k][n];
        int min = Integer.MAX_VALUE;
        int i = 1, max = n;
        // for(int i=1;i<=n;i++){
        while(i<=max){
            int x = -1, y = -1;
            int mid = i+(max-i)/2;
            if(dp[k-1][mid-1]!=-1)
                x = dp[k-1][mid-1];
            else 
                x = dropIt(k-1, mid-1, dp);
            if(dp[k][n-mid] != -1)
                y = dp[k][n-mid];
            else
                y = dropIt(k, n-mid, dp);
            
            int t = 1+Math.max(x, y);
            if(x<y)
                i = mid+1;
            else
                max = mid-1;
            min = Math.min(min, t);
        }
        return dp[k][n] = min;
    }
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k+1][n+1];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
        return dropIt(k, n, dp);
    }
}