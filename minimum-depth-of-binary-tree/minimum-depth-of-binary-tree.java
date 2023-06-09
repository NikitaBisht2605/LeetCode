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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int cnt=0;
        if(root==null){
            return cnt;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            cnt++;
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left==null && queue.peek().right==null){
                    return cnt;
                }
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                queue.poll();
            }
        }
        return cnt;
    }
}