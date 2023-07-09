class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<int[]>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(q.size()==0 && fresh==0){
            return 0;
        }
        int time=0;
        int[][] vis=new int[n][m];
        int curr=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] arr=q.poll();
                int x=arr[0];
                int y=arr[1];
                grid[x][y]=2;
                if(x-1>=0 && grid[x-1][y]==1 && vis[x-1][y]!=1){
                    q.offer(new int[]{x-1,y});
                    vis[x-1][y]=1;
                    curr++;
                }
                if(x+1<n && grid[x+1][y]==1 && vis[x+1][y]!=1){
                    q.offer(new int[]{x+1,y});
                    vis[x+1][y]=1;
                    curr++;
                }
                if(y-1>=0 && grid[x][y-1]==1 && vis[x][y-1]!=1){
                    q.offer(new int[]{x,y-1});
                    vis[x][y-1]=1;
                    curr++;
                }
                if(y+1<m && grid[x][y+1]==1 && vis[x][y+1]!=1){
                    q.offer(new int[]{x,y+1});
                    vis[x][y+1]=1;
                    curr++;
                }
            }
            time++;
        }
        if(curr==fresh){
            return time-1;
        }
        return -1;
    }
}