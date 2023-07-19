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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return false;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            int flag=0;
            int a=0;
            int b=0;
            for(int i=0;i<len;i++){
                flag=0;
                if(queue.peek().left!=null){
                    if(queue.peek().left.val==x || queue.peek().left.val==y){
                        flag++;
                        a++;
                    }
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    if(queue.peek().right.val==x || queue.peek().right.val==y){
                        flag++;
                        b++;
                    }
                    queue.offer(queue.peek().right);
                }
                queue.poll();
                if(flag==2){
                    return false;
                }
            }
            if(a==1 && b==1 || b==2 || a==2){
                return true;
            }
        }
        return false;
    }
}