//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<int[]> q=new LinkedList<>();
        int[] vis=new int[V];
        q.offer(new int[]{0,-1});
        //System.out.println(V);
        for(int k=0;k<V;k++){
            if(vis[k]==0){
                vis[k]=1;
                q.offer(new int[]{k,-1});
                while(!q.isEmpty()){
                    int len=q.size();
                    for(int i=0;i<len;i++){
                        int[] arr=q.poll();
                        int x=arr[0];
                        int y=arr[1];
                        for(Integer j:adj.get(x)){
                            if(vis[j]==0){
                                q.offer(new int[]{j,x});
                            }
                            if(vis[j]==1 && y!=j){
                                return true;
                            }
                            vis[j]=1;
                        }
                    }
                }
            }
        }
        return false;
    }
}