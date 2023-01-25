//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
       int res = s.length();
        int n = s.length();
        
        String temp = "";
        int max = 0;
        for(int i = 0; i < n; i ++) {
            temp += s.charAt(i);
            if(s.substring(i + 1).contains(temp)) {
                max = Math.max(max, i);
            }
        }
        return res - max;
    }
}