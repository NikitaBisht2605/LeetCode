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

/** A set to store the values*/
    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        /** null check*/
        if(root == null) return false;

        /** we check the value to determine if we have a pair*/
        int val = root.val;
        if(set.contains(k - val)) return true;

        /** otherwise we keep traversing until we find one or we return false*/
        set.add(val);
        return findTarget(root.left, k) ||
                findTarget(root.right, k);
    }
}