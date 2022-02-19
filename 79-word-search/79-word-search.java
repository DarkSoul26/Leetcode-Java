class Solution {
    public boolean getTheWord(char[][] board, String word, int n, int m, int i, int j, int len, boolean[][] isVisited){
        if(len>=word.length())
            return true;
        if(board[i][j] != word.charAt(len) || isVisited[i][j])
            return false;
        isVisited[i][j] = true;
        if(i<n-1)
            if(getTheWord(board, word, n, m, i+1, j, len+1, isVisited))
                return true;
        if(j<m-1)
            if(getTheWord(board, word, n, m, i, j+1, len+1, isVisited))
                return true;
        if(i>0)
            if(getTheWord(board, word, n, m, i-1, j, len+1, isVisited))
                return true;
        if(j>0)
            if(getTheWord(board, word, n, m, i, j-1, len+1, isVisited))
                return true;
        isVisited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited= new boolean[board.length][board[0].length];
        if(board.length == 1 && board[0].length == 1)
            if(board[0][0] == word.charAt(0) && word.length() == 1)
                return true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(getTheWord(board, word, board.length, board[0].length, i, j, 0, isVisited))
                    return true;
            }
        }
        return false;
    }
}