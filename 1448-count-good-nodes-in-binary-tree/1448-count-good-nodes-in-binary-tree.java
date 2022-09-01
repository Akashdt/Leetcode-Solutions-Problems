class Solution {

    public int goodNodes(TreeNode root) 
    {
        if (root == null) return 0;
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max) 
    {
        if (root == null) 
                
                return 0;

        max = Math.max(root.val, max);
            
        if (root.val >= max) 
        {
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        } 
            else 
        {
            return dfs(root.left, max) + dfs(root.right, max);
        }
    }
}
