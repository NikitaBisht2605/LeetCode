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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode dummy=root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }
    TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        else{
            TreeNode rightPart=root.right;
            TreeNode largestRight=root.left;
            root=root.left;
            while(largestRight.right!=null){
                largestRight=largestRight.right;
            }
            largestRight.right=rightPart;
            return root;
        }
    }
}