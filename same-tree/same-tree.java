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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] b=new boolean[1];
        b[0]=false;
        check(p,q,b);
        return b[0];
    }
    static boolean check(TreeNode p,TreeNode q,boolean[] b){
        if(p==null && q==null){
            b[0]=true;
            return true;
        }
        if(p==null || q==null){
            b[0]=false;
            return false;
        }
        if(p.val==q.val){
            b[0]=true;
            if(check(p.left,q.left,b)==false){
                return false;
            }
            if(check(p.right,q.right,b)==false){
                return false;
            }
        }
        else{
            b[0]=false;
            return false;
        }
        b[0]=true;
        return true;
    }
}