class Solution {
    public int countNegatives(int[][] grid) {
        int cnt=0;
        int row=0;
        int col=grid[0].length-1;
        while(row<grid.length && col>=0){
            //System.out.println(grid[row][col]);
            if(grid[row][col]<0){
                cnt=cnt+grid.length-row;
                col--;
            }
            else{
                row++;
            }
        }
        return cnt;
    }
}