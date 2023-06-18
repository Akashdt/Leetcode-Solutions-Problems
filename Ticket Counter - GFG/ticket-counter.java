//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        Deque<Integer> dq = new LinkedList<>();
        while(N>0){
            dq.addFirst(N);N--;
        }
        int prev = 0,count = K;
        int round = 1;
        while(!dq.isEmpty()){
            if(round%2 != 0){
                while(count-->0){
                    prev = dq.peek();
                    dq.removeFirst();
                    if(dq.isEmpty()){
                        return prev;
                    }
                }
            }else{
                while(count-->0){
                    prev = dq.peekLast();
                    dq.removeLast();
                    if(dq.isEmpty()){
                        return prev;
                    }
                }
            }
            round++;count = K;
        }
        return prev;
    }
}