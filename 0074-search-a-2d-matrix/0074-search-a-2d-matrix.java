class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len=matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(target<=matrix[i][len]){
                boolean b=binarysearch(matrix,i,target);
                if(b==true){
                    return true;
                }
                else{
                    return false;
                }
            }
            
        }
        return false;
        
    }
    static boolean binarysearch(int[][] matrix, int a, int target){
        int end=matrix[a].length-1;
        int start=0;
        int mid=(start+end)/2;
        while(start<=end){
            mid=(start+end)/2;
            if(target<matrix[a][mid]){
                end=mid-1;
            }
            else if(target>matrix[a][mid]){
                start=mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}