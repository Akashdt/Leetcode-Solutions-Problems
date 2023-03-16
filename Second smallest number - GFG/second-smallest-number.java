//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
       if(S < 2 || D == 1 || (9*D) <= S){ return "-1"; }
        
        int[] arr = new int[D];
        
        for(int i=D-1; i>=0; i--){
            
            if(i == 0){ arr[i] = S; }
            else if((S-1) >= 9){ arr[i] = 9; S -= 9; }
            else{ arr[i] = S-1; S = 1; }
            
        }
        
        for(int i=D-2; i>=0; i--){
            
            if(arr[i] < 9){
                arr[i+1]--;
                arr[i]++;
                break;
            }
            
        }
        
        
        StringBuilder str = new StringBuilder();
        
        for(int i : arr) str.append(i);
        
        return str.toString();
    }
}