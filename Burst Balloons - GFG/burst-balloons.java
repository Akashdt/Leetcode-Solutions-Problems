//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
    int[][] dp = new int[N+2][N+2];

        int[] nums = new int[N+2];

        nums[0] = 1;

        nums[N+1] = 1;

        for(int i = 1; i <=N; i++) nums[i] = arr[i-1];

        for(int gap = 1; gap <=N; gap++){

            for(int left = 1; left <= N - gap + 1; left++){

                int right = left + gap - 1;

                for(int k = left; k <= right; k++)

            dp[left][right] = Math.max(dp[left][right], nums[left-1] * nums[k] * nums[right+1] + dp[left][k-1] + dp[k+1][right]);

            }

        }

        return dp[1][N];



  }
}
     