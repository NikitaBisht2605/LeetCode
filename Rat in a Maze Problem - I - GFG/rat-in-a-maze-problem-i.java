//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0]==0){
            return ans;
        }
        String s="";
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            vis[i][j] = 0;
          }
        }
        combination(0,0,s,ans,m,n,vis);
        return ans;
    }
    static void combination(int row, int col, String s,ArrayList<String> ans,int[][] m,int n,int vis[][]){
        if(row==n-1 && col==n-1){
            ans.add(s);
            return;
        }
        //Down
        if(row!=n-1 && vis[row+1][col]==0 && m[row+1][col]==1){
            vis[row][col]=1;
            combination(row+1,col,s+'D',ans,m,n,vis);
            vis[row][col]=0;
        }
        //Left
        if(col!=0 && vis[row][col-1]==0 && m[row][col-1]==1){
            vis[row][col]=1;
            combination(row,col-1,s+'L',ans,m,n,vis);
            vis[row][col]=0;
        }
        //Right
        if(col!=n-1 && vis[row][col+1]==0 && m[row][col+1]==1){
            vis[row][col]=1;
            combination(row,col+1,s+'R',ans,m,n,vis);
            vis[row][col]=0;
        }
        //Up
        if(row!=0 && vis[row-1][col]==0 && m[row-1][col]==1){
            vis[row][col]=1;
            combination(row-1,col,s+'U',ans,m,n,vis);
            vis[row][col]=0;
        }
    }
    
}