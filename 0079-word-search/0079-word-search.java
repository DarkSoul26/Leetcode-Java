class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        char a = word.charAt(0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == a){
                    if(dfs(i,j,0,visit,board,word))
                        return true;
                    // System.out.println();
                }
            }
        }
        return false;
    }
    
    
    public boolean dfs(int i, int j, int k, boolean[][] visit, char[][] board, String word){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        if(visit[i][j])
            return false;
        visit[i][j] = true;
        boolean ans = false;
        if(word.charAt(k) == board[i][j]){
            
            // System.out.print(word.charAt(k)+" "+i+" "+j);
            if(k == word.length()-1)
                return true;
            ans = dfs(i+1, j, k+1, visit, board, word) ||
                dfs(i, j+1, k+1, visit, board, word) ||
                dfs(i-1, j, k+1, visit, board, word) ||
                dfs(i, j-1, k+1, visit, board, word);
        }
        visit[i][j] = false;
        
        return ans;
    }
}