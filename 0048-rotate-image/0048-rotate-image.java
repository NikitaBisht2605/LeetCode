class Solution {
    public void rotate(int[][] matrix) {
        int a=matrix.length-1;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int k=1;
        for(int j=0;j<matrix.length/2;j++){
            for(int i=0;i<matrix.length;i++){
                int temp=matrix[i][j+a+1-k];
                matrix[i][j+a+1-k]=matrix[i][j];
                matrix[i][j]=temp;   
                             
            }
            k=k+2;
        }
        
    }
}