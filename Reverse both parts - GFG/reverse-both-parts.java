//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++)
            tail = tail.next = new Node(Integer.parseInt(s[i]));

        return head;
    }

    public static void printList(Node node)
    {
        while (node != null)
        {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node head = Node.inputList(br);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            Node res = obj.reverse(head, k);
            
            Node.printList(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

 

class Solution {

    

    public static Node reverseit(Node head)

    {

        Node curr=head,fur=head,prev=null;

        

        while(curr!=null)

        {

            fur=curr.next;

            curr.next=prev;

            prev=curr;

            curr=fur;

        }

        return prev;

        

    }

    

    public static Node reverse(Node head, int k) {

     

     if(head==null) return head;

     

     Node newhead= new Node(-1);

     newhead.next=head;

     

     head=newhead;

     Node old_head=head.next;

      Node temp=head;

     

     while(temp!=null && k-- > 0 )

     {

         temp=temp.next;

     }

     

     Node save= temp.next;

     temp.next=null;

     

     Node newhd1= reverseit(head.next);

     

     Node newhd2= reverseit(save);

     

     old_head.next=newhd2;

     

     return newhd1;

   

    }

 

}
        
