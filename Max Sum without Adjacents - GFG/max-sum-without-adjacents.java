//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

 class Solution {

    int findMaxSum(int arr[], int n) {

        // code here

        if(n==1)

            return arr[0];        

        if(n>2)                    

            arr[n-3]+=arr[n-1];  
        

        for(int i=n-4;i>=0;i--)

        {

            arr[i]+=Math.max(arr[i+2],arr[i+3]); 

        }

        

        return Math.max(arr[0],arr[1]);    //The answer can be available on any of the index 0th or 1st so return the maximum one.

    }

}