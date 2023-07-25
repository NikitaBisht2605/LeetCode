class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
        
        int k=matrix.length-1;
        for(int i=0;i<matrix.length/2;i++){
            for(int j=0;j<matrix.length;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[j][k-i];
                matrix[j][k-i]=temp;
            }
        }
    }
}