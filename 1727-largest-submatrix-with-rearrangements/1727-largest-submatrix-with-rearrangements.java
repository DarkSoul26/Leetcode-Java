class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
       for(int j=0;j<m;j++){
           int sum=0;
           for(int i=0;i<n;i++){
               sum=matrix[i][j]==0 ? 0 : sum+1;
               matrix[i][j]=sum;
           }
       }
    int ans=0;
       for(int arr[] : matrix){
           Arrays.sort(arr);
           for(int i=0;i<m;i++)
           ans=Math.max(ans,arr[i]*(m-i));
       }
        return ans;
    }
}