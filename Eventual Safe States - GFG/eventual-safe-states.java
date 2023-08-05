//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,pathvis,adj);
            }
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(pathvis[i]==0){
                list.add(i);
            }
        }
        return list;
    }
    static boolean dfs(int i, int[] vis, int[] pathvis,List<List<Integer>> adj){
        vis[i]=1;
        pathvis[i]=1;
        for(Integer j:adj.get(i)){
            if(pathvis[j]==1 && vis[j]==1){
                return true; //part of a cycle or connected to a cycle
            }
            else if(pathvis[j]==0 && vis[j]==0){
                if(dfs(j,vis,pathvis,adj)==true){
                    return true;
                }
            }
        }
        pathvis[i]=0;
        return false;
    }
}
