class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length, t = 0, b = matrix.length;
        List<Integer> al = new ArrayList<>();
        while(l<r || t<b){
            for(int i=l;i<r;i++)
                al.add(matrix[t][i]);
            t++;
            if(t>=b)
                break;
            for(int i=t;i<b;i++)
                al.add(matrix[i][r-1]);
            r--;
            if(r<=l)
                break;
            for(int i=r-1;i>=l;i--)
                al.add(matrix[b-1][i]);
            b--;
            if(t>=b)
                break;
            for(int i=b-1;i>=t;i--)
                al.add(matrix[i][l]);
            l++;
            if(r<=l)
                break;
        }
        return al;
    }
}