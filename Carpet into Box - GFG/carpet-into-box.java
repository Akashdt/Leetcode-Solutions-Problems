//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
   int carpetBox(int A, int B, int C, int D) { 
        //code here
        return Math.min(solve(A,B,C,D),solve(A,B,D,C));
    }
    int solve(int a , int b , int c, int d){
        if(a<=c && b<=d)
            return 0;
        
        if(a>c) return 1+ solve((a/2),b,c,d);
        if(b>d) return 1+ solve(a,(b/2),c,d);
        return 0;
    }
   
}
