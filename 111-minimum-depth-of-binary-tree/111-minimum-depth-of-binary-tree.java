
class Solution {
    public int minDepth(TreeNode root) 
    {
        if(root==null)
        return 0;
            
    int left=minDepth(root.left);
      int right=minDepth(root.right);
    if(left==0)
                  return 1+right;
            if(right==0)
                    return 1+left;
            else
               return 1+Math.min(left,right);
    }
}