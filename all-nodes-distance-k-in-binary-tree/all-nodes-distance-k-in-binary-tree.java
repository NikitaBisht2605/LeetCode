/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    void findparent(TreeNode root,Map<TreeNode,TreeNode> parent_map){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                    parent_map.put(queue.peek().left,queue.peek());
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                    parent_map.put(queue.peek().right,queue.peek());
                }
                queue.poll();
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_map=new HashMap<>();
        findparent(root,parent_map);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(q.peek(),true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k){
                break;
            }
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent_map.get(current)!=null && visited.get(parent_map.get(current))==null){
                    q.offer(parent_map.get(current));
                    visited.put(parent_map.get(current),true);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}