//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static String buildLowestNumber(String str, int N) 
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++)
        {
            char min = str.charAt(i);
            int idx = i;
            
            int j=i+1;
            for( ; j<=i+N && j<str.length(); j++)
            {
                if(str.charAt(j) < min)
                {
                    min = str.charAt(j);
                    idx = j;
                }
            }
            
            if(j<=i+N) break;
            
            N -= (idx-i);
            sb.append(str.charAt(idx));
            i=idx;
            
            if(N==0)
            {
                ++i;
                
                while(i < str.length())
                {
                    sb.append(str.charAt(i));
                    i++;
                }
                
                break;
            }
        }
        
        int i=0;
        while(i<sb.length()-1)
        {
            if(sb.charAt(i)!='0') break;
            
            sb.deleteCharAt(i);
        }
        
        return sb.toString();
    }
}