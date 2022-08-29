class Solution {
    public boolean isSafe(char[][] b, int i, int j, char k){
        for(int l=0;l<9;l++){
            if(l!=j && b[i][l] == k)
                return false;
            
            if( l!=i && b[l][j] == k)
                return false;
            
            if(i!=3*(i/3)+l/3 && j!= 3*(i/3)+l%3 && b[3*(i/3)+l/3][3*(j/3)+l%3] == k)
                return false;
        }
        return true;
    }
    public boolean solveIt(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(int k=1;k<=9;k++){
                        char x = (char)(k+'0');
                        if(isSafe(board, i, j, x)){
                            board[i][j] = x;
                            if(solveIt(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    // if(board[i][j] == '.')
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // boolean x = solveIt(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                // if(board[i][j] == '.')
                //     return false;
                if(board[i][j]!='.')
                    if(!isSafe(board, i, j, board[i][j]))
                        return false;
                
            }
            // System.out.println();
        }   
        
        return true;
    }
}