class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && vis[0][i]==0){
                dfs(0,i,grid,vis,n,m);
            }
            if(grid[n-1][i]==1 && vis[n-1][i]==0){
                dfs(n-1,i,grid,vis,n,m);
            }
        }

        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i,0,grid,vis,n,m);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(i,m-1,grid,vis,n,m);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    static void dfs(int i, int j, int[][] grid, int[][] vis,int n,int m){
        vis[i][j]=1;
        if(i-1>=0 && vis[i-1][j]==0 && grid[i-1][j]==1){
            dfs(i-1,j,grid,vis,n,m);
        }
        if(i+1<n && vis[i+1][j]==0 && grid[i+1][j]==1){
            dfs(i+1,j,grid,vis,n,m);
        }
        if(j-1>=0 && vis[i][j-1]==0 && grid[i][j-1]==1){
            dfs(i,j-1,grid,vis,n,m);
        }
        if(j+1<m && vis[i][j+1]==0 && grid[i][j+1]==1){
            dfs(i,j+1,grid,vis,n,m);
        }
    }
}