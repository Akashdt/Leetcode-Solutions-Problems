
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> order = new ArrayList<>();
            post(root,order);
            return order;
    }
        void post(TreeNode root,List<Integer> order)
        {
                if(root == null)
                {
                        return;
                }
                post(root.left, order);
        
        post(root.right, order);
                order.add(root.val);
        }
}