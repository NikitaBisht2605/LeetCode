class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    arr.add(i);
                    arr.add(j);
                }
            }
        }
        
        for(int i=0;i<arr.size()-1;i=i+2){
            setZero(matrix,arr.get(i),arr.get(i+1));
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //System.out.print(matrix[i][j]+" ");
            }
            //System.out.println();
        }
    }
    static void setZero(int matrix[][],int i, int j){
        for(int k=0;k<matrix[0].length;k++){
            matrix[i][k]=0;
        }
        for(int k=0;k<matrix.length;k++){
            matrix[k][j]=0;
        }
    }
}