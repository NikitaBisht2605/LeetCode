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
    private int k=1;
    private int max=0;
    TreeNode pre=null;
    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        ArrayList<Integer> arr=new ArrayList<>();
        helper(root,arr);
        int[] res = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) 
            res[i] = arr.get(i);
        return res;
    }
    void helper(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        helper(root.left,arr);
        if(pre!=null){
            if(pre.val==root.val){
                k++;
            }
            else{
                k=1;
            }
        }
        pre=new TreeNode(root.val);
        if (k > max) 
        {
            max = k;
            arr.clear();
            arr.add(root.val);
        } 
        else if (k == max) 
            arr.add(root.val);
        helper(root.right,arr);
    }
}