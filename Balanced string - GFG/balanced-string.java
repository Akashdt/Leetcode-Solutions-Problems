//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
String ans="";
        String z="abcdefghijklmnopqrstuvwxyz";
        int t=N/26, n=N%26,s,e; 
        for(int i=0;i<t;i++) ans+=z;
        if(n%2==0) s=n/2;
        else{
            if(check(N)) s=(n+1)/2;
            else s=(n-1)/2;
        }
        e=n-s;
        return ans + z.substring(0, s)+ z.substring(26-e);
    }
    static boolean check(int n){
      int sum=0;
      while(n>0){
          sum+=n%10;
          n=n/10;
      }
      return sum%2==0?true:false;
    }
}