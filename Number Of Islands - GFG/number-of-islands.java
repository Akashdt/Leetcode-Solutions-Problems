//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public List<Integer> numOfIslands(int n, int m, int[][] op) {
         int[][] arr = new int[n][m];
        int k=1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<op.length; i++){
            int count=0;
            arr[op[i][0]][op[i][1]]=k;
            for(int p=0; p<n; p++){
                for(int q=0; q<m; q++){
                    if(arr[p][q]==k){
                        dfs(arr, p, q, n, m, k);   
                        count++;
                    }
                }
            }
            
            list.add(count);
            k++;
        }
        return list;
    }
    
    public void dfs(int[][] arr, int i, int j, int n, int m, int k){
        if(i>=0 && j>=0 && i<n && j<m && arr[i][j]==k){
            arr[i][j]+=1;
            
            dfs(arr, i, j+1, n, m, k);
            dfs(arr, i+1, j, n, m, k);
            dfs(arr, i-1, j, n, m, k);
            dfs(arr, i, j-1, n, m, k);
        }
    }
    }
    


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends