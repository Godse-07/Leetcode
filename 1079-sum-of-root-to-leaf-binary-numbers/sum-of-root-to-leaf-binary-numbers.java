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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 2 + node.val;

        if (node.left == null && node.right == null) {
            return current;
        }

        return helper(node.left, current) + helper(node.right, current);
    }
}