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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> list= new LinkedList<List<Integer>>();
        if(root==null){
            return list;
        }
        int flag=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subList=new LinkedList<Integer>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            if(flag==0){
                list.add(subList);
                flag=1;
            }
            else{
                Collections.reverse(subList);
                list.add(subList);
                flag=0;
            }
        }
        return list;
    }
}