//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dominantPairs(int n, int[] arr) {
        // code here
        for(int i = n/2 ;i < n;i++){
           arr[i] = arr[i]*5;
        }
        Arrays.sort(arr, n/2, n);
        Arrays.sort(arr, 0, n/2);
        
        int ans =0;
        for(int i = n/2-1;i >= 0;i--){
            int s = n/2;
            int e = n-1;
            while(s <= e){
                int mid = (s+e)/2;
                if(arr[mid] <= arr[i]) s = mid+1;
                else e = mid-1;
            }
            
            if(e < n/2) break;
            ans = ans + e - n/2 + 1;
        }
        
        return ans;
    }
}
        
