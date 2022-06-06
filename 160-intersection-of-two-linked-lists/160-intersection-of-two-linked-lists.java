/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
         HashSet<ListNode> sa = new HashSet<ListNode>();
        
      
        while(headA!=null)
        {
            sa.add(headA);
            headA = headA.next;
        }
            
        while(headB!=null){
            if(sa.contains(headB))
            {
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}