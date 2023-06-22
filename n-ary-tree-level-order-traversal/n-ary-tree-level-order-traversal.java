/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<Node>();
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<len;i++){
                if(!queue.peek().children.isEmpty()){
                    List<Node> nodes=queue.peek().children;
                    for(int j=0;j<nodes.size();j++){
                        queue.offer(nodes.get(j));
                    }
                }
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}