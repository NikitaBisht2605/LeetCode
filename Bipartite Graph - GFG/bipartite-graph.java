//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color=new int[V];
        for(int j=0;j<V;j++){
            color[j]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean dfs(int ind,int val,int[] color,ArrayList<ArrayList<Integer>> adj){
        if(ind!=0){
            color[ind]=1-val;
        }
        else{
            color[ind]=0;
        }
        for(Integer i:adj.get(ind)){
            if(color[i]==-1){
                if(dfs(i,color[ind],color,adj)==false){
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