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
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode _node,int _num){
        node=_node;
        num=_num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int len=q.size();
            int mmin=q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<len;i++){
                int cur_id=q.peek().num-mmin;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0){
                    first=cur_id;
                }
                if(i==len-1){
                    last=cur_id;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,cur_id*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,cur_id*2+2));
                }
            }
            ans=Math.max(last-first+1,ans);
        }
        return ans;
    }
}