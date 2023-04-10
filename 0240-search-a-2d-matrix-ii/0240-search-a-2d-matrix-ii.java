class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        while(j>=0 && i<matrix.length){
            if(target<matrix[i][j]){
                j=j-1;
            }
            else if(target>matrix[i][j]){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}