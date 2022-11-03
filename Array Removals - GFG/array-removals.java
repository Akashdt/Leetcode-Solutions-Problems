//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
          Arrays.sort(arr);

        

        int t=n-1,min=Integer.MAX_VALUE;

        

        while(t>=0)

        {

            if(t==0)

            return Math.min(min,n-1);

            int i=0,j=t-1,ub=-1;

            

            while(i<=j)

            {

                int mid=(i+j)/2;

                if(arr[mid]<=arr[t]-k)

                {

                    ub=mid;

                    i=mid+1;

                }

                else

                    j=mid-1;

            }

            

            if(ub==-1||arr[ub]!=arr[t]-k)

            ub+=1;

            

            if(ub>=0&&arr[t]-arr[ub]<=k)

            min=Math.min(min,ub+n-t-1);

            t--;

        }

        return min;
    }
}