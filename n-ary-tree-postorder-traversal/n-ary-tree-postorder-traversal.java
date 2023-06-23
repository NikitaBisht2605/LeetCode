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
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        postorderTraversal(list,root);
        return list;
    }
    static void postorderTraversal(List<Integer> list, Node root){
        if(root==null){
            return;
        }
        List<Node> nodes=root.children;
        if(nodes.size()!=0){
            for(int i=0;i<nodes.size();i++){  
                postorderTraversal(list,nodes.get(i)); 
            }
        }
        else{
            list.add(root.val);
            return;
        }
        list.add(root.val);
    }
}