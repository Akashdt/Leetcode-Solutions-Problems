
class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> order = new ArrayList<>();
        inOrder(root, order);
        return order;
    }
    
    
    void inOrder(TreeNode root, List<Integer> order) 
    {
        if(root == null) return;
        inOrder(root.left, order);
        order.add(root.val);
        inOrder(root.right, order);
    }
}