class Solution {
    int dp[] = new int[10];
    int ans = 1000000000;
    
    public void dist(int[] cookies, int n, int k){
        if(n == cookies.length){
            int max = 0;
            for(int i=0;i<k;i++)
                max = Math.max(max, dp[i]);
            ans = Math.min(ans, max);
            
            return;
        }
        
        for(int i=0;i<k;i++){
            dp[i] +=cookies[n];
            dist(cookies, n+1, k);
            dp[i] -= cookies[n];
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        dist(cookies, 0, k);
        return ans;
    }
}