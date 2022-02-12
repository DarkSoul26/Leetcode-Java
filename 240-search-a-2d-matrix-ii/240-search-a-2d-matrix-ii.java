class Solution {
    
    public boolean searchIt(int[][] matrix, int target, int i){
        int l = 0;
        int r = matrix[0].length-1;
        int mid = 0;
        int a = 0;
        while(l<=r){
            mid = l+(r-l)/2;
            a = matrix[i][mid];
            if(a == target)
                return true;
            else if(a > target)
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] <= target && matrix[i][matrix[0].length-1] >= target){
                if(searchIt(matrix, target, i))
                    return true;
            }
        }
        return false;
    }
}