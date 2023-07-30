//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>> set=new HashSet<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> list=new ArrayList<>();
                    dfs(i,j,vis,list,i,j,grid);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    static void dfs(int row, int col,int[][] vis, ArrayList<String> list, int origRow, int origCol,int[][] grid){
        vis[row][col]=1;
        list.add(Integer.toString(row-origRow)+" "+Integer.toString(col-origCol));
        if(row-1>=0 && vis[row-1][col]==0 && grid[row-1][col]==1){
            dfs(row-1,col,vis,list,origRow,origCol,grid);
        }
        if(row+1<grid.length && vis[row+1][col]==0 && grid[row+1][col]==1){
            dfs(row+1,col,vis,list,origRow,origCol,grid);
        }
        if(col-1>=0 && vis[row][col-1]==0 && grid[row][col-1]==1){
            dfs(row,col-1,vis,list,origRow,origCol,grid);
        }
        if(col+1<grid[0].length && vis[row][col+1]==0 && grid[row][col+1]==1){
            dfs(row,col+1,vis,list,origRow,origCol,grid);
        }
    }
}
