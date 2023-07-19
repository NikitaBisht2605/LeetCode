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
    public int maxPathSum(TreeNode root) {
        if(root!=null && root.left==null && root.right==null){
            return root.val;
        }
        int[] maxSum=new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        TreeNode root2=root;
        findMax(root,maxSum);
        return maxSum[0];
    }
    int findMax(TreeNode root,int[] maxSum){
        if(root==null){
            return 0;
        }
        int lh=Math.max(0,findMax(root.left,maxSum));
        int rh=Math.max(0,findMax(root.right,maxSum));
        maxSum[0]=Math.max(maxSum[0],lh+rh+root.val);
        return root.val+Math.max(lh,rh);
    }
}