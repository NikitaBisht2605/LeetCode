class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int[] vis=new int[isConnected.length];
        for(int k=0;k<isConnected.length;k++){
            if(vis[k]==0){
                cnt++;
                dfs(k,vis,list);
            }
        }
        return cnt;
    }
    static void dfs(int node,int[] vis,List<List<Integer>> list){
        vis[node]=1;
        for(Integer it:list.get(node)){
            if(vis[it]==0){
                dfs(it,vis,list);
            }
        }
        return;
    }
}