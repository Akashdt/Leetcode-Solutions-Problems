//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    public static long findSubarray(long[] arr ,int n) {

        Map<Long,Long> mp = new HashMap<>();

        long ans =0,sum=0;

        for(int i=0;i<n;i++){

            sum+=arr[i];

            ans += (sum == 0 ? 1 + mp.getOrDefault(sum,new Long("0")) : mp.getOrDefault(sum,new Long("0")));

            mp.put(sum,mp.getOrDefault(sum,new Long("0"))+1);

        }

        return ans;

    }

}