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
    static boolean findTarget(TreeNode root, int start,List<TreeNode> list){
        if(root==null){
            return false;
        }
        if(root.val==start){
            list.add(root);
            return true;
        }
        if(findTarget(root.left,start,list)==true){
            return true;
        }
        if(findTarget(root.right,start,list)==true){
            return true;
        }
        return false;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root.left==null && root.right==null){
            return 0;
        }
        Map<TreeNode,TreeNode> parent_map=new HashMap<>();
        findparent(root,parent_map);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<TreeNode> list=new LinkedList<TreeNode>();
        findTarget(root,start,list);
        TreeNode target=list.get(0);
        System.out.println(target.val);
        q.offer(target);
        visited.put(q.peek(),true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            int inf=0;
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                    inf=1;
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                    inf=1;
                }
                if(parent_map.get(current)!=null && visited.get(parent_map.get(current))==null){
                    q.offer(parent_map.get(current));
                    visited.put(parent_map.get(current),true);
                    inf=1;
                }
            } 
            if(inf==1){
                curr_level++;
            }
        }
        return curr_level;
    }
}