
class Solution {
   
         List arr1 = new ArrayList();
    List arr2 = new ArrayList();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        visitLeaf(root1, arr1);
        visitLeaf(root2, arr2);
       
	  
        if(arr1.size() != arr2.size()) {
            return false;
        }
        for(int i = 0; i < arr1.size(); i++) {
            if(arr1.get(i) != arr2.get(i)) {
                return false;
            }
        }
        return true;
    }   
    private void visitLeaf(TreeNode root, List arr) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null)
        {
            arr.add(root.val);
        } 
        
        visitLeaf(root.left, arr);
        visitLeaf(root.right, arr);  
    }
    }
