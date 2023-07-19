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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode node=q.poll();
                if(node.left!=null && node.right!=null){
                    TreeNode temp=node.left;
                    node.left=node.right;
                    node.right=temp;
                    q.offer(node.right);
                    q.offer(node.left);
                }
                else if(node.left!=null){
                    q.offer(node.left);
                    node.right=node.left;
                    node.left=null;
                } 
                else if(node.right!=null){
                    q.offer(node.right);
                    node.left=node.right;
                    node.right=null;
                } 
            }
        }
        return root;
    }
}