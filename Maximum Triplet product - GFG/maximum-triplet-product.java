//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {

    Long maxTripletProduct(Long arr[], int n) {

        

        // Time: O(N*Log(N)) & Space: O(1)

        // Arrays.sort(arr);

        // return Math.max(arr[n-1]*arr[n-2]*arr[n-3], arr[n-1]*arr[0]*arr[1]);

        

        // Time: O(N) & Space: O(1)

        

        // Finding the 3 Maximum No.s & 3 Minimum No.s

        Long max1 = Long.MIN_VALUE;

        Long max2 = Long.MIN_VALUE;

        Long max3 = Long.MIN_VALUE;

        Long min1 = Long.MAX_VALUE;

        Long min2 = Long.MAX_VALUE;

        Long min3 = Long.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            

            Long val = arr[i];

            

            // Finding the 3 Maximum No.s

            if(val >= max1) {

                max3 = max2;

                max2 = max1;

                max1 = val;

            } else if(val >= max2 && val < max1) {

                max3 = max2;

                max2 = val;

            } else if(val >= max3 && val < max2) {

                max3 = val;

            }

            // Finding the 3 Minimum No.s

            if(val <= min1) {

                min3 = min2;

                min2 = min1;

                min1 = val;

            } else if(val <= min2 && val > min1) {

                min3 = min2;

                min2 = val;

            } else if(val <= min3 && val > min2) {

                min3 = val;

            }

        }

        

        return Math.max(max1*max2*max3, max1*min1*min2);

    }

}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends