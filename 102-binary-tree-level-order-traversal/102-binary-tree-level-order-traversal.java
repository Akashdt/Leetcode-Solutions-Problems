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
   public List<List<Integer>> levelOrder(TreeNode root)
   {
        List<List<Integer>> levelOrder = new ArrayList<>();
        traverseTreeInLveleOrder(root, 1, levelOrder);
        return levelOrder;
    }
        void traverseTreeInLveleOrder(TreeNode node, int level, List<List<Integer>> ds) 
        {
        if (node == null)
            return;
        
       
        if (ds.size() < level) 
        {
            ds.add(new ArrayList<Integer>());
                
            ds.get(level - 1).add(node.val);
                
        } 
                else 
        {
            ds.get(level - 1).add(node.val);
        }
        
        traverseTreeInLveleOrder(node.left, level + 1, ds);
        traverseTreeInLveleOrder(node.right, level + 1, ds);
    }
   
}