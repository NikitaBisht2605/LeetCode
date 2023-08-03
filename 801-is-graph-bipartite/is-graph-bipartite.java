class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        for(int j=0;j<V;j++){
            color[j]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean dfs(int ind,int val,int[] color,int[][] graph){
        if(ind!=0){
            color[ind]=1-val;
        }
        else{
            color[ind]=0;
        }
        for(int i:graph[ind]){
            if(color[i]==-1){
                if(dfs(i,color[ind],color,graph)==false){
                    return false;
                }
            }
            else if(color[ind]==color[i]){
                return false;
            }
        }
        return true;
    }
}