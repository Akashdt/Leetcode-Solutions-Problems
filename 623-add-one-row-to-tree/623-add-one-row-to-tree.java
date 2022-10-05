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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currDepth = 0;
        
        while(! queue.isEmpty()) {
            int lvlSize = queue.size();
            currDepth++;
            
            for(int i = 0; i < lvlSize; i++) {
                TreeNode currNode = queue.poll();
                if(depth == 1) {
                    TreeNode newRoot = new TreeNode(val);
                    newRoot.left = currNode;
                    root = newRoot;
                }
                
                if(currDepth + 1 == depth) {
                    TreeNode leftNode = new TreeNode(val);
                    leftNode.left = currNode.left;
                    TreeNode rightNode = new TreeNode(val);
                    rightNode.right = currNode.right;
                    
                    currNode.left = leftNode;
                    currNode.right = rightNode;
                }
                
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            if(currDepth == depth) {
                break;
            }
        }
        
        return root;
    }
}