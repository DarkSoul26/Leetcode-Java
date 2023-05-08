class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=mat[i][i];
        }
        for(int i=0;i<n;i++){
            sum+=mat[i][n-i-1];
        }
        if(n%2!=0){
            int x=(n+1)/2;
            sum-=mat[x-1][x-1];
        }
        return sum;
    }
}