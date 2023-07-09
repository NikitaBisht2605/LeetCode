class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dest=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] arr=q.poll();
                int x=arr[0];
                int y=arr[1];
                int z=arr[2];
                dest[x][y]=z;
                if(x-1>=0 && vis[x-1][y]==0){
                    q.offer(new int[]{x-1,y,z+1});
                    vis[x-1][y]=1;
                }
                if(x+1<n && vis[x+1][y]==0){
                    q.offer(new int[]{x+1,y,z+1});
                    vis[x+1][y]=1;
                }
                if(y-1>=0 && vis[x][y-1]==0){
                    q.offer(new int[]{x,y-1,z+1});
                    vis[x][y-1]=1;
                }
                if(y+1<m && vis[x][y+1]==0){
                    q.offer(new int[]{x,y+1,z+1});
                    vis[x][y+1]=1;
                }
            }
        }
        return dest;
    }
}