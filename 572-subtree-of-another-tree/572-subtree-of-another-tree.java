
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
                
                return false;
            else if(sametree(s,t))
            {
                    return true;
            }
            else
                    return isSubtree(s.left,t)|| isSubtree(s.right,t);
    }
        public boolean sametree(TreeNode s,TreeNode t)
        {
                if(s==null || t== null)
                {
                        return s==null && t==null;
                }
                else if(s.val==t.val)
                {
                        return sametree(s.left,t.left) && sametree(s.right,t.right);
                }
                else
                {
                        return false;
                }
        }
}