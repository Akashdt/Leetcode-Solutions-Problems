/**
 *
 */
class Solution 
{
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
        {
            return null;
        }
            
        TreeNode inv =root;
        
        TreeNode left=invertTree(inv.left);
        TreeNode right=invertTree(inv.right);
        
        inv.left = right;
        inv.right = left;
        
        return root;
    }
}