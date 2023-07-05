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
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        ArrayList<ArrayList<Integer>> dp= new ArrayList<ArrayList<Integer>>(n+1);

        for(int i=0; i<=n; i++) {
            dp.add(new ArrayList<Integer>(2));
        }
        
        dp.get(n).add(0,0);
        dp.get(n).add(1,0);
        
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<=1; j++) {
                int b=Integer.MIN_VALUE,s=Integer.MIN_VALUE;
                if(j==1) {
                    b = -prices[i]+dp.get(i+1).get(0);
                    s = 0 + dp.get(i+1).get(1);
                }
                else {
                    s = prices[i]+dp.get(i+1).get(1);
                    b = 0 + dp.get(i+1).get(0);
                }
                int maxi = Math.max(b,s);
                dp.get(i).add(j,maxi);
            }
        }
        
        return dp.get(0).get(1);
    }
}
        
