class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int k=1;k<n;k++){
            for(int i=k, j=1;(i<n && j<m);i++,j++){
                if(matrix[i-1][j-1]!=matrix[i][j])
                    return false;
            }
        }
        for(int k=1;k<m;k++){
            for(int i=1, j=k;(i<n && j<m);i++,j++){
                if(matrix[i-1][j-1]!=matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}