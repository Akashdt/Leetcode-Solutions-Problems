//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        int[] freq=new int[26];
        int start=0;
        int end=0;
        int max=0;
        while(start<=end && end<n){
            freq[arr.charAt(end)-'A']++;
            while(start<=end && freq['O'-'A']>m){
                freq[arr.charAt(start)-'A']--;
                start++;
            }
            max=Math.max(end-start+1,max);
            end++;
        }
        return max;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends