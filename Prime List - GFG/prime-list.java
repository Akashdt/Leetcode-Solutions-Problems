//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
      Node node = head;
        
        while(node != null){
            int right = rightPrime(node.val);
            int left = leftPrime(node.val);
            //check min
            if(node.val == 1){
                node.val = 2;
            } else if(node.val-left == right-node.val){
                node.val = left;
            } else {
                node.val = node.val-left < right-node.val ? left : right;
            }
            node = node.next;
        }
        return head;
    }
    
    int rightPrime(int num){
        for(int i=num; i<40000; i++){
            boolean flag = true;
            for(int j=2; j*j<=i; j++){
                if(i%j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return 0;
    }
    
        
    int leftPrime(int num){
        for(int i=num; i>=2; i--){
            boolean flag = true;
            for(int j=2; j*j<=i; j++){
                if(i%j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return 0;
        
    }
}