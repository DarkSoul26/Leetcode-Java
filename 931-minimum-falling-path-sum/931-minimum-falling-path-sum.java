class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<m;i++)
            dp[0][i] = matrix[0][i];
        // for(int i=1;i<n;i++)
        //     dp[i][0] = matrix[i][0];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j>0 && j<m-1)
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                if(j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                if(j == m-1)
                     dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+-1]);
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
            ans = Math.min(dp[n-1][i], ans);
        
        return ans;
    }
}