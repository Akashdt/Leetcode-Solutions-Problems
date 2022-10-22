//{ Driver Code Starts
//Initial Template for Java


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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
       Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i=0;i<=9;i++){
            q.add(i);
            while(!q.isEmpty()){
                int t = q.poll();
                if(t>=n && t <= m)
                    ans++;
                if(t == 0 || t > m)
                    continue;
                int d = t%10;
                if(d == 0)
                    q.add(t*10 + d+1);
                else if(d == 9)
                    q.add(t*10 + d-1);
                else{
                    q.add(t*10 + d-1);
                    q.add(t*10 + d+1);
                }
            }
        }
        return ans;
    }
}
