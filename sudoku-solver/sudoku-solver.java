class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    static boolean solve(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(validate(row,col,c,board)){
                            board[row][col]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[row][col]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean validate(int row, int col,char c,char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i]==c){
                return false;
            }
            if(board[i][col]==c){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
        }
        return true;
    }

}