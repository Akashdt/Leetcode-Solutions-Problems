class Solution 
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if(preorder.length == 0)
        {
            return null ;
        }
        int n = inorder.length ;
            
        return result(preorder,0,n-1,inorder,0,n-1) ;
    }
    
    public static TreeNode result(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd)
        {
            return null ;
        }
        int i=0; 
        for(i=inStart; i<= inEnd; i++)
        { 
            if (inorder[i] == preorder[preStart])
            {
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]) ;
            
        int rem = i - inStart ;
        
      root.left = result(preorder,preStart+1,preStart+rem+1,inorder,inStart,i-1);
        
     root.right = result(preorder,preStart+rem+1,preEnd,inorder,i+1,inEnd);
       
            return root ;
    }
}