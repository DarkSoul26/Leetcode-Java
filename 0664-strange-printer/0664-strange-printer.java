class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return calc(0,n-1,s,dp);
    }

    public int calc(int l,int h,String s,int[][] dp){

        if(l>h){
            return 0;
        }
        if(l==h){
            return 1;
        }

        if(dp[l][h]!=-1)
            return dp[l][h];

        int min = 1 + calc(l+1,h,s,dp);
        for(int j=l+1;j<=h;j++){
            if(s.charAt(l)==s.charAt(j)){
                min = Math.min(min,calc(l+1,j-1,s,dp)+calc(j,h,s,dp));
            }
        }

        return dp[l][h]=min;
    }
}