/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x)
    {
        ListNode temp=head;
        List<Integer>list=new ArrayList<>();
        while(head!=null)
        {
            if(head.val<x)
            {
                list.add(head.val);
            }
            head=head.next;
        }
        head=temp;
        while(head!=null)
        {
            if(head.val>=x)list.add(head.val);
            head=head.next;
        }
        
            int c=0;
        ListNode res=temp;
            
        while(temp!=null)
        {
            temp.val=list.get(c++);
            temp=temp.next;
        }
        return res;
    }
}