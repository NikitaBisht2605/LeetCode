class Solution {
    public int equalPairs(int[][] grid) {
        int b=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                b=b+matrix(i,j,grid);
            }
        }
        return b;
    }
    static int matrix(int i, int j, int[][] grid){
        int count=0;
        for(int k=0;k<grid.length;k++){
            if(grid[i][k]==grid[k][j]){
                count++;
            }
        }
        if(count==grid.length){
            return 1;
        }
        return 0;
    }
}