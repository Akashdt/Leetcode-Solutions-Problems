//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
      TreeMap<Integer,Integer> dp = new TreeMap<>();
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]));
        dp.put(0,0);
        
        for (int interval[]: intervals){
            // include: 
            // currInterval_profit + maxProfit from prev non-overlapping interval
        
            int profit_from_greatestIdx_smaller_than_currIdx = dp.floorEntry(interval[0]).getValue();
            int currentProfit = 
interval[2] + profit_from_greatestIdx_smaller_than_currIdx;
            
            // prev greatest profit --- similar to dp[i-1]
            int lastMaxProfit = dp.lastEntry().getValue();
            
            if (lastMaxProfit < currentProfit){
                dp.put(interval[1], currentProfit);
            }
        }
        return dp.lastEntry().getValue();
    }
}
