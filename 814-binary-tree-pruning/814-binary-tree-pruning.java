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
     public int check1Count(TreeNode root){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            
            if(root.val == 0)
                return 0;
            else
                return 1;
        }
        
        int leftCount = check1Count(root.left);
        int rightCount = check1Count(root.right);
        
        if(leftCount == 0){
            root.left = null;
        }
        if(rightCount == 0){
            root.right = null;
        }
        
        return leftCount+rightCount+(root.val==1?1:0);
    }
    
    public TreeNode pruneTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        if(check1Count(root) == 0){
            return null;
        }
        
        return root; 
    }
}