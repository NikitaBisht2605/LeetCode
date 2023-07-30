class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]==0){
                dfs(0,i,vis,board);
            }
            if(board[n-1][i]=='O' && vis[n-1][i]==0){
                dfs(n-1,i,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,board);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    static void dfs(int x,int y, int[][] vis, char[][] board){
        //System.out.println(board[x][y]);
        vis[x][y]=1;
        int n=board.length;
        int m=board[0].length;
        if(x-1>=0 && vis[x-1][y]==0 && board[x-1][y]=='O'){
            dfs(x-1,y,vis,board);
        }
        if(x+1<n && vis[x+1][y]==0 && board[x+1][y]=='O'){
            dfs(x+1,y,vis,board);
        }
        if(y-1>=0 && vis[x][y-1]==0 && board[x][y-1]=='O'){
            dfs(x,y-1,vis,board);
        }
        if(y+1<m && vis[x][y+1]==0 && board[x][y+1]=='O'){
            dfs(x,y+1,vis,board);
        }
    }
}