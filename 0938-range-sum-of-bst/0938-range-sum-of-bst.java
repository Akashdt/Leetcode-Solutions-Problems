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
    public int rangeSumBST(TreeNode root, int low, int high) {
         int sum = 0;
        if(root == null){
            return 0;
        }else if(low <= root.val && root.val <= high){
            sum += root.val;
        }
        return sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}