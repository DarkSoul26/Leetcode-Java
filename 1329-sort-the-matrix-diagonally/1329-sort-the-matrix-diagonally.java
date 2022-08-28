class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            List<Integer> al = new ArrayList<>();
            for(int j=0, k = i;(j<mat.length && k<mat[0].length);j++,k++){
                al.add(mat[j][k]);
            }
            Collections.sort(al);
            for(int j=0, k = i;(j<mat.length && k<mat[0].length);j++,k++){
                mat[j][k] = al.get(j);
            }
        }
        for(int i=0;i<mat.length;i++){
            List<Integer> al = new ArrayList<>();
            for(int j=i, k = 0;(j<mat.length && k<mat[0].length);j++,k++){
                al.add(mat[j][k]);
            }
            Collections.sort(al);
            for(int j=i, k = 0;(j<mat.length && k<mat[0].length);j++,k++){
                mat[j][k] = al.get(k);
            }
        }
        return mat;
    }
}