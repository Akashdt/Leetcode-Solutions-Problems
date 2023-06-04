//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        StringBuilder ans = new StringBuilder();
        StringBuilder currNum = new StringBuilder();
        for(int i = S.length()-1; i >= 0; i--) {
            char ch = S.charAt(i);
            try {
                currNum.append(Integer.parseInt(String.valueOf(ch)));
            } catch (Exception e) {
                currNum.reverse();
                ans.append(currNum);
                ans.append(ch);
                currNum= new StringBuilder();
            }
        }
        currNum.reverse();
        ans.append(currNum);
        return ans.toString();
    }
}