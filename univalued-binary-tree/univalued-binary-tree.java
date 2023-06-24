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
    public boolean isUnivalTree(TreeNode root) {
        return check(root,root.val);
       
    }
    static boolean check(TreeNode p,int i){
        if(p==null){
            return true;
        }
        if(p.val==i){
            if(check(p.left,i)==false){
                return false;
            }
            if(check(p.right,i)==false){
                return false;
            }
        }
        else{
            return false;
        }
        return true;
    }
}