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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        recursion(list,root);
        return list;
    }
    static void recursion(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        recursion(list,root.left);
        recursion(list,root.right);
    }
}