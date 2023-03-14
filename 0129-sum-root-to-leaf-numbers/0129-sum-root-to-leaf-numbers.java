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
 */class Solution {
    List<Integer> li = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        helper(root,root.val);
        int res = 0;
        for(Integer i : li){
            res+=i;
        }
        return res;
    }
    public void helper(TreeNode root,int num){
        if(root.right == null && root.left == null){
            li.add(num);
        }
        if(root.left!=null){
        helper(root.left,num*10+root.left.val);
        }
        if(root.right!=null){
            helper(root.right,num*10+root.right.val);
        }

    }
}