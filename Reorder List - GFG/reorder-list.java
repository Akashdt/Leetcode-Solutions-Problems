//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {

    Node reorderlist(Node head) {

        if(head.next==null)

        return head;

        if(head.next.next==null)

        return head;

        int count=0;

        Node temp=head;

        while(temp!=null)

          {

          count++;

          temp=temp.next;

          }

          count=count/2;

         temp=head;

         Node prev=null;

         for(int i=1;i<=count;i++)

         {

             prev=temp;

             temp=temp.next;

         }

         prev.next=null;

         Node h2=reverse(temp);

         Node h1=head;

         Node p1=null;

         Node p2=null;

         while(h1!=null || h2!=null)

         {

             p1=h1.next;

             p2=h2.next;

             h1.next=h2;

             if(p1==null)

             return head;

             h2.next=p1;

             h1=p1;

             h2=p2;

         }

         return head;

}

    Node reverse(Node head)

    {

        Node prev=null;

        Node curr=head;

        Node n=null;

        while(curr!=null)

        {

            n=curr.next;

            curr.next=prev;

            prev=curr;

            curr=n;

        }

        return prev;

    }

}