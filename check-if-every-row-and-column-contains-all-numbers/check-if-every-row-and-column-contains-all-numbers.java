class Solution {
    public boolean checkValid(int[][] matrix) {
        return fillNum(matrix);
    }
    static boolean check(int[][] matrix,int row, int col){
        int count=0;
        int c=matrix[row][col];
        for(int i=0;i<matrix.length;i++){
            if(matrix[row][i]==c){
                count++;
            }
            if(matrix[i][col]==c){
                count++;
            }
            if(count>2){
                return false;
            }
        }
        return true;
    }
    static boolean fillNum(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(check(matrix,i,j)==false){
                    return false;
                }
            }
        }
        return true;
    }
}