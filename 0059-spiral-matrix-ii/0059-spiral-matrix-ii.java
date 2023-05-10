class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n, t = 0, b = n;
        // List<Integer> al = new ArrayList<>();
        int matrix[][] = new int[n][n];
        int num = 1;
        while(l<r || t<b){
            for(int i=l;i<r;i++)
                matrix[t][i] = num++;
            t++;
            if(t>=b)
                break;
            for(int i=t;i<b;i++)
                matrix[i][r-1] = num++;;
            r--;
            if(r<=l)
                break;
            for(int i=r-1;i>=l;i--)
                matrix[b-1][i] = num++;
            b--;
            if(t>=b)
                break;
            for(int i=b-1;i>=t;i--)
                matrix[i][l] = num++;
            l++;
            if(r<=l)
                break;
        }
        return matrix;
    }
}