class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                p.add(matrix[i][j]);
                if(p.size()>k){
                    p.poll();
                }
            }
        }
        return p.peek();
    }
}