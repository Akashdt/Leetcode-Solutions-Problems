//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {int low=0,high=1000000000,ans=0;
        Arrays.sort(stalls);
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(isPossible(stalls,mid,k,n)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int[] arr,int mid,int k,int n){
        // as we have already place the cow at arr[0]
        int count=1,prevPos=arr[0];
        
        for(int i=1;i<n;i++){
            // if curr arr[i] - previous place where cow is placed is greater than mid 
            // increase count
            if(arr[i]-prevPos>=mid){
                count++;
                // if count is equal to k means we placed all cows return true
                if(count==k) return true;
                // else store prev to current arr[i]
                prevPos=arr[i];
            }
        }
        // if we failed to place then return flase;
        return false;}
}