
class Solution
{
   HashSet<Integer> hs = new HashSet<>();
        
    public boolean findTarget(TreeNode root, int k)
    {
        if (root==null) 
                
                return false;
        if (hs.contains(root.val)) 
                
                return true;
        hs.add(k-root.val);
            
        return findTarget(root.right, k) || findTarget(root.left, k);
    }
}