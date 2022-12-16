//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
       int ans = 0;
        
        if(ty == 0){
            int a = i>0 ?mat[i-1][j] :0;
            int b = j>0 ?mat[i][j-1] :0;
            int c = j<(m-1) ?mat[i][j+1] :0;
            int d = i<(n-1) ?mat[i+1][j] :0;
            int e,f;
            
            if(j%2 == 1){
                e = (j>0 && i<(n-1)) ?mat[i+1][j-1] :0;
                f = (j<(m-1) && i<(n-1)) ?mat[i+1][j+1] :0;
            }
            else{
                e = (i>0 && j>0) ?mat[i-1][j-1] :0;
                f =  (i>0 && j<(m-1)) ?mat[i-1][j+1] :0;
            }
            
            ans = a+b+c+d+e+f;
            
        }
        else{
            int a = i>1 ?mat[i-2][j] :0;
            int c = (i>0 && j<(m-2)) ?mat[i-1][j+2] :0;
            int d = j<(m-2) ?mat[i][j+2] :0;
            int e = (i<(n-1) && j<(m-2)) ?mat[i+1][j+2] :0;
            int g = i<(n-2) ?mat[i+2][j] :0;
            int k = (i<(n-1) && j>1) ?mat[i+1][j-2] :0;
            int l = (j>1) ?mat[i][j-2] :0;
            int o = (i>0 && j>1) ?mat[i-1][j-2] :0;
            
            int b,f,h,p;
            
            if(j%2 ==1){
                b = (i>0 && j<(m-1)) ?mat[i-1][j+1] :0;
                f = (i<(n-2) && j<(m-1)) ?mat[i+2][j+1] :0;
                h = (i<(n-2) && j>0) ?mat[i+2][j-1] :0;
                p = (i>0 && j>0) ?mat[i-1][j-1] :0;
            }
            else{
                b = (i<(n-1) && j>0) ?mat[i+1][j-1] :0;
                f = (i<(n-1) && j<(m-1)) ?mat[i+1][j+1] :0;
                h = (i>1 && j>0) ?mat[i-2][j-1] :0;
                p = (i>1 && j<(m-1)) ?mat[i-2][j+1] :0;
            }
            
            
            ans = a+b+c+d+e+f+g+h+k+l+o+p;
            
        }
        return ans;
    }
}