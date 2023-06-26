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
 class Tuple{
    TreeNode node;
    int col;
    int row;
    public Tuple(TreeNode _node,int _col,int _row){
        node=_node;
        row=_row;
        col=_col;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        if(root==null){
            return arr;
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tuple> q=new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode node=tuple.node;
            int x=tuple.col;
            int y=tuple.row;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            else{
                map.get(x).clear();
            }
            map.get(x).put(y,new PriorityQueue<Integer>());
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,x+1,y-1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> tree:map.values()){
            for(PriorityQueue<Integer> pq:tree.values()){
                arr.add(pq.poll());
            }
        }
        return arr;
    }
}