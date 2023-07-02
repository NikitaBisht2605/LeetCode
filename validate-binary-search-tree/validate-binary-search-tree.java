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
    private boolean isValid=true;
    private TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }
    private void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        if(pre!=null && pre.val>=node.val){
            isValid=false;
            return;
        }
        pre=node;
        helper(node.right);
    }
}