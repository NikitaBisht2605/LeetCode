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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list2=new ArrayList<>();
        String s="";
        s=s.concat("->");
        reachLeaf(root,s,list2);
        return list2;
    }
    void reachLeaf(TreeNode node,String s,List<String> list2){
        if(node.left==null && node.right==null){
            s=s.concat(Integer.toString(node.val));
            s=s.substring(2,s.length());
            //System.out.println(s);
            list2.add(new String(s));
            return;
        }
        s=s+Integer.toString(node.val)+"->";
        //System.out.println(s);
        if(node.left!=null){
            reachLeaf(node.left,s,list2);
            //s=s.substring(0,s.length()-1);
            System.out.println(s);
        }
        if(node.right!=null){
            reachLeaf(node.right,s,list2);
            //s=s.substring(0,s.length());
            System.out.println(s);
        }
    }
}