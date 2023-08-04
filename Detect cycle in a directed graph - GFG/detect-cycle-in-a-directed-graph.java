//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,adj)==true){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(int i,int[] vis, int[] pathvis,ArrayList<ArrayList<Integer>> adj){
        vis[i]=1;
        pathvis[i]=1;
        for(Integer j:adj.get(i)){
            if(vis[j]==1 && pathvis[j]==1){
                return true;
            }
            else if(vis[j]==0 && pathvis[j]==0){
                if(dfs(j,vis,pathvis,adj)==true){
                    return true;
                }
            }
        }
        pathvis[i]=0;
        return false;
    }
}