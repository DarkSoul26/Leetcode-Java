class Solution {
public double champagneTower(int poured, int query_row, int query_glass) {

    double[][] dp = new double[100+1][100+1];
    
    dp[0][0]=poured;
    
    for(int i=0;i<=query_row;i++)
    {
        for(int j=0;j<=i;j++)
        {
            if(dp[i][j]>1)
            {
                double exc=dp[i][j]-1.0;
                
                dp[i][j]=1.0;
                dp[i+1][j]+=exc/2.0;  //left
                dp[i+1][j+1]+=exc/2.0; //right
            }
        }
    }
    
    return dp[query_row][query_glass];
}
}