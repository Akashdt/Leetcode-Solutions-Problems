
class Solution {
     public boolean isSymmetric(TreeNode root) {
        if (root == null)
		    return true;
       
	    return isSymmetric(root.left, root.right);
    }
   
    public boolean isSymmetric(TreeNode rootleft, TreeNode rootright) {
        
	    if (rootleft == null && rootright == null) {
		    return true;
            }
        else if (rootright == null || rootleft == null) {
		    return false;
	    }
        
        if (rootleft.val != rootright.val)
		    return false;
     
        if (!isSymmetric(rootleft.left, rootright.right))
		    return false;
	    if (!isSymmetric(rootleft.right, rootright.left))
		    return false;
       
        return true;
    
    }
}