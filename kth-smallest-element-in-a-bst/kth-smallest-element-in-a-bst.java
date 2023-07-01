/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] arr=new int[1];
        arr[0]=0;
        return recursive(root,k,arr);
        
    }
    int recursive(TreeNode root, int k,int[] arr){
        if(root==null){
            return -1;
        }
        int a=recursive(root.left,k,arr);
        if(a!=-1){
            return a;
        }
        arr[0]=arr[0]+1;
        if(arr[0]==k){
            return root.val;
        }
        a=recursive(root.right,k,arr);
        if(a!=-1){
            return a;
        }
        return -1;
    }
}