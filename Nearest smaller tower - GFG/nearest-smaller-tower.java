//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int [] nearestSmallestTower(int [] a){
        int n = a.length; 
        int[] left = new int[n];
        int[] right = new int[n]; 
        
        Stack<Integer> st = new Stack<>(); 
        
        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                left[i] =-1; 
            }else{
                while(!st.isEmpty() &&a[st.peek()] >= a[i]){
                    st.pop(); 
                }
                if(st.isEmpty()){
                    left[i] = -1; 
                }else{
                    left[i] = st.peek(); 
                }
            }
            st.push(i); 
        }
        st = new Stack<>(); 
        for(int i=n-1; i>=0; i--){
            if(st.isEmpty()){
                right[i] =-1; 
            }else{
                while(!st.isEmpty() &&a[st.peek()] >= a[i]){
                    st.pop(); 
                }
                if(st.isEmpty()){
                    right[i] = -1; 
                }else{
                    right[i] = st.peek(); 
                }
            }
            st.push(i); 
        }
        
        int[] ans = new int[n]; 
        for(int i=0; i<n; i++){
            if(left[i]==-1 && right[i] == -1){
                ans[i] =-1; 
            }else if(left[i]==-1){
                ans[i]= right[i]; 
            }else if(right[i]==-1){
                ans[i] = left[i]; 
            }else{
                if(Math.abs(right[i] - i)==Math.abs(i -left[i])){
                    ans[i] = a[right[i]] < a[left[i]] ? right[i] : left[i]; 
                }else if(Math.abs(right[i] - i) > Math.abs(i -left[i])){
                    ans[i] = left[i]; 
                }else{
                    ans[i] =right[i]; 
                }
            }            
        }
        return ans; 
    }
}