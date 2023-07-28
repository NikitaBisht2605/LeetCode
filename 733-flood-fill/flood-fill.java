class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=image[i][j];
            }
        }
        int[][] vis=new int[n][m];
        Queue<int[]> q=new LinkedList<int[]>();
        q.offer(new int[]{sr,sc,image[sr][sc]});
        vis[sr][sc]=1;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] arr=q.poll();
                int x=arr[0];
                int y=arr[1];
                int val=arr[2];
                
                if(x-1>=0 && image[x-1][y]==image[x][y] && vis[x-1][y]!=1){
                    vis[x-1][y]=1;
                    q.offer(new int[]{x-1,y,image[x-1][y]});
                }
                if(y-1>=0 && image[x][y-1]==image[x][y] && vis[x][y-1]!=1){
                    vis[x][y-1]=1;
                    q.offer(new int[]{x,y-1,image[x][y-1]});
                }
                if(x+1<n && image[x+1][y]==image[x][y] && vis[x+1][y]!=1){
                    vis[x+1][y]=1;
                    q.offer(new int[]{x+1,y,image[x+1][y]});
                }
                if(y+1<m && image[x][y+1]==image[x][y] && vis[x][y+1]!=1){
                    vis[x][y+1]=1;
                    q.offer(new int[]{x,y+1,image[x][y+1]});
                }
                ans[x][y]=color;
            }
        }
        return ans;
    }
}