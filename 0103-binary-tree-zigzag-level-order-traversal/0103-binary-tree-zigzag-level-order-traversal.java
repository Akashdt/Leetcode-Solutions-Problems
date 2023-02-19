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
   List<List<Integer>>list=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        find(root);
       return list;
    }
  
  public void find(TreeNode root){
    if(root==null)return;
    
    Queue<TreeNode>q=new LinkedList<>();
    q.offer(root);
    
    int i=0;
    
    while(!q.isEmpty()){
      List<Integer>li=new ArrayList<>();
      
      int size=q.size();
      while(size-->0){
         TreeNode node=q.poll();
        
        li.add(node.val);
        
        if(node.left!=null){
          q.offer(node.left);
        }
        if(node.right!=null){
          q.offer(node.right);
        }
      }
      
      if((i&1)==0){
        list.add(li);
      }
      else{
        Collections.reverse(li);
        list.add(li);
      }
      i++;
    }
  }
}