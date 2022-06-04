class Solution {
    public List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] row = new boolean[n];
        fill(board, 0, row);
        return ans;
    }
    
    public void fill(boolean[][] board, int row, boolean[] col) {
          if(row == col.length) {
              print(board);
              return;
          }
          for(int i = 0; i < col.length; i++) {
              if(col[i] == false) {
                  if(check(board, row, i)) {
                      board[row][i] = true;
                      col[i] = true;
                      fill(board, row + 1, col);
                      col[i] = false;
                      board[row][i] = false;
                  }
              }
          }
      }

      public boolean check(boolean[][] board, int row, int col) {
          int i = row - 1;
          int j = col - 1;
          while(i >= 0 && j >= 0) {
              if(board[i][j] == true) {
                  return false;
              }
              i--;
              j--;
          }

          i = row - 1;
          j = col + 1;
          while(i >= 0 && j < board.length) {
              if(board[i][j] == true) {
                  return false;
              }
              i--;
              j++;
          }
          return true;
      }
    
      public void print(boolean[][] board) {
          List<String> toadd = new ArrayList<>(); 
          for(int i = 0; i < board.length; i++) {
              StringBuilder add  = new StringBuilder();
              for(int j = 0; j < board.length; j++) {
                  if(board[i][j] == true)
                      add.append("Q");
                  else
                      add.append(".");
              }
              toadd.add(add + "");
          }
          ans.add(toadd);
      }
}