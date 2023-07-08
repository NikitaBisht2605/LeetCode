class Solution {
    public int numIslands(char[][] grid) {
        // ArrayList<ArrayList<Integer>> adj=new ArrayList<AraayList<Integer>>();
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         if(grid[i][j]==1){
        //             adj.add(new Arraylist<Integer>());
        //         }
        //         if(grid[i][j]==1 && i!=j){
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,vis,grid,n,m);
                }
            }
        }
        return cnt;
    }
    static void dfs(int i, int j, int[][] vis, char[][] grid, int n, int m){
        vis[i][j]=1;
        for(int delrow = -1; delrow <= 1; delrow++){
            for(int delcol = -1; delcol <= 1; delcol++){
                int nrow = i + delrow;
                int ncol = j + delcol;
                if((delrow==-1 && delcol==0)||(delrow==0 && delcol==1) || (delrow==1 && delcol==0) || (delrow==0 && delcol==-1)){
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] =='1')
                    {
                        dfs(nrow, ncol, vis, grid, n, m);
                    }
                }
            }
        }
    }
}