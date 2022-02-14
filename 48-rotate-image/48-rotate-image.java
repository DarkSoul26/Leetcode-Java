class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0,k=matrix[0].length-1;(j<=matrix[0].length/2 && k>=matrix[0].length/2);j++,k--){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
        
    }
}