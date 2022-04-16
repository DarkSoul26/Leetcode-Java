class Solution {
    
    public boolean isPali(String s, int i, int j){
        for(int k=i,l=j;(k<=(i+j)/2 && l>=(i+j)/2);k++,l--)
            if(s.charAt(k)!=s.charAt(l))
                return false;
        return true;
    }
   
    public int solveIt(String s, int i, int j, int dp[][]){
        if(i>=j)
            return dp[i][j] = 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(isPali(s, i, j))
            return dp[i][j] = 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if(isPali(s,i,k))
                ans=Math.min(ans,1 + solveIt(s,k+1,j,dp));
//             //int cost = 1;
//             if(dp[i][k]==-1)
//                 dp[i][k] = solveIt(s,i,k,dp);
//             if(dp[k+1][j]==-1)
//                 dp[k+1][j] = solveIt(s,k+1,j,dp);
                
//             int cost=dp[k+1][j]+dp[i][k]+1;
//             // int cost = solveIt(s, i, k, dp)+solveIt(s, k+1, j, dp)+1;
//             ans = Math.min(ans, cost);
        }
        
        return dp[i][j] = ans;
    }
    public int minCut(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int[] dp1: dp)
            Arrays.fill(dp1, -1);
        int x = solveIt(s, 0, s.length()-1, dp);
        // for(int i=0;i<s.length();i++){
        //     for(int j = 0;j<s.length();j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }
        return x;
    }
}