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
    int sum;
    int minDiff = Integer.MAX_VALUE;
    long MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        sumTree(root);
        dfs(root);
        long a = (sum + minDiff) / 2;
        long b = sum - a;
        return (int)((a * b) % MOD);
    }

    public void sumTree(TreeNode curr) {
        if (curr == null)
            return;
        sum += curr.val;
        sumTree(curr.left);
        sumTree(curr.right);
    }

    public int dfs (TreeNode curr) {
        if (curr == null)
            return 0;
        
        int leftSum = dfs(curr.left);
        int rightSum = dfs(curr.right);

        int leftDiff = Math.abs((sum - leftSum) - leftSum);
        int rightDiff = Math.abs((sum - rightSum) - rightSum);
        minDiff = Math.min(minDiff, Math.min(leftDiff, rightDiff));

        return leftSum + rightSum + curr.val;
    }
}