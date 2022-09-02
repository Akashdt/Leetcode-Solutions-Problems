/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list=new ArrayList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int s = queue.size();
            long sum = 0;
            
            for(int i=0;i<s;i++)
            {
                TreeNode curr = queue.poll();
                sum+=curr.val;
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            
            double avg = (double)sum/s;
            list.add(avg);
        }
        return list;
    }
}