class Solution {
    public void solveSudoku(char[][] board) {
        fillNum(board);
    }
    static boolean check(char[][] board,int row, int col,char c){
        //Checking vetically and horizontally
        for(int i=0;i<board.length;i++){
            if(board[row][i]==c || board[i][col]==c){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
        }
        return true;      
    }
    static boolean fillNum(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(check(board,i,j,c)){
                            board[i][j]=c;
                            if(fillNum(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}