//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    int dp[];
    public int cutRod(int price[], int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, price);
        
    }
    int solve(int n, int[] price){
        if(dp[n] != -1) return dp[n];
        if(n == 0) return 0;
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans , price[i] + solve(n-i-1, price));
        }
        return dp[n] = ans;
    }
}