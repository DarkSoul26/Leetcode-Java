class Solution {
    
    int ans = 0;
    public int totalNQueens(int n) {
        boolean arr[][] = new boolean[n][n];
        boolean col[] = new boolean[n];
        fillIt(arr, col, 0);
        return ans;
    }
    
    public void fillIt(boolean[][] arr, boolean[] col, int r){
        if(r>=arr.length){
            ans++;
            return;
        }
        
        // for(boolean c: col){
        for(int i=0;i<col.length;i++){
            if(!col[i]){
                if(checkIt(arr, r, i)){
                    col[i] = true;
                    arr[r][i] = true;
                    fillIt(arr, col, r+1);
                    col[i] = false;
                    arr[r][i] = false;
                }
            }
        }
    }
    
    public boolean checkIt(boolean[][] arr, int r, int c){
        int i1 = r-1;
        int j1 = c-1;
        while(i1>=0 && j1>=0){
            if(arr[i1][j1])
                return false;
            i1--;
            j1--;
        }
        
        i1 = r-1;
        j1 = c+1;
        
        while(i1>=0 && j1<arr.length){
            if(arr[i1][j1])
                return false;
            i1--;
            j1++;
        }
        
        return true;
    }
}