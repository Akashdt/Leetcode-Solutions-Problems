// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int arr[], int n)
    {
         int i=0,l=0,r=n-1;
       
       while(i<=r){
           if(arr[i]==1)i++;
           else if(arr[i]==0){
               int temp=arr[i];
               arr[i]=arr[l];
               arr[l]=temp;
               i++;
               l++;
           }
           else {
              int temp=arr[i];
              arr[i]=arr[r];
              arr[r]=temp;
              r--;
           }
       }
       
   }
    }


// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends