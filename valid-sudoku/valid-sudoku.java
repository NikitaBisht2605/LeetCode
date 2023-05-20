class Solution {
    public boolean isValidSudoku(char[][] board) {
        return fillNum(board);
    }
    static boolean check(char[][] board,int row, int col){
        int count=0;
        char c=board[row][col];
        for(int i=0;i<board.length;i++){
            if(board[row][i]==c){
                count++;
            }
            if(board[i][col]==c){
                count++;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                count++;
            }
            if(count>3){
                return false;
            }
        }
        return true;
    }
    static boolean fillNum(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){
                    if(check(board,i,j)==false){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}