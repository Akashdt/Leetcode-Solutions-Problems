
 
class Solution {
         boolean isBalanced = true;
    public int maxh(TreeNode root)
    {
          if(root == null) 
                  return 0;
        
            if(! isBalanced) 
                    return 0;
        
        int p = maxh(root.left);
        int q = maxh(root.right);
        
        if(Math.abs(p -q) > 1) 
        {
                isBalanced = false;
        }
        
        return Math.max(p, q) + 1;
    }

    public boolean isBalanced(TreeNode root) 
    {
        maxh(root);
        return isBalanced;
    }
        
    }
