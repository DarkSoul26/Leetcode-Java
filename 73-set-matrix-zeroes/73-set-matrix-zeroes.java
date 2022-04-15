class Solution {
    
    public void setAll0(int[][] matrix, int i, int j){
        for(int m = 0;m<matrix[0].length;m++)
            matrix[i][m] = 0;
        for(int m = 0;m<matrix.length;m++)
            matrix[m][j] = 0;
    }
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> al1 = new ArrayList<>();
                    al1.add(i);
                    al1.add(j);
                    al.add(al1);
                }
            }
        }
        for(int i=0;i<al.size();i++)
            setAll0(matrix, al.get(i).get(0), al.get(i).get(1));
    }
}