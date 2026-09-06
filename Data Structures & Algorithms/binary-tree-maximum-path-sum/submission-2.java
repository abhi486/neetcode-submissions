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
    long ans;
    long solve(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        // if (root.left == null && root.right == null) {
        //     ans = Math.max(ans, root.val);
        //     return root.val;
        // }

        long left = Math.max(0, solve(root.left));
        long right = Math.max(0, solve(root.right));

        ans = Math.max(ans, left + root.val + right);

        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        solve(root);

        return (int)ans;
    }
}
