class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<int[]>();
        int[][] vis=new int[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                    vis[i][j]=1;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int cnt=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] arr=q.poll();
                int x=arr[0];
                int y=arr[1];
                int t=arr[2];
                time=Math.max(time,t);
                //System.out.println(time);
                if(x-1>=0 && grid[x-1][y]==1 && vis[x-1][y]!=1){
                    vis[x-1][y]=1;
                    q.offer(new int[]{x-1,y,time+1});
                    cnt++;
                }
                if(x+1<n && grid[x+1][y]==1 && vis[x+1][y]!=1){
                    vis[x+1][y]=1;
                    q.offer(new int[]{x+1,y,time+1});
                    cnt++;
                }
                if(y-1>=0 && grid[x][y-1]==1 && vis[x][y-1]!=1){
                    vis[x][y-1]=1;
                    q.offer(new int[]{x,y-1,time+1});
                    cnt++;
                }
                if(y+1<m && grid[x][y+1]==1 && vis[x][y+1]!=1){
                    vis[x][y+1]=1;
                    q.offer(new int[]{x,y+1,time+1});
                    cnt++;
                }
            }
        }
        if(cnt!=fresh){
            return -1;
        }
        return time;
    }
}