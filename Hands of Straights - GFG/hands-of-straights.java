//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int n, int groupSize, int hand[]) {
        if(n%groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer>m = new TreeMap<>();
        for(int i=0;i<n;i++){
            if(m.containsKey(hand[i]))
                m.put(hand[i],m.get(hand[i])+1);
            else
                m.put(hand[i],1);
        }
        while(m.size()>0){
            int k=groupSize;
            int key=(int)m.firstKey();
            while(k>0){
                if(m.containsKey(key)){
                    m.put(key,m.get(key)-1);
                }else{
                    break;
                }
                if(m.get(key)==0)
                    m.remove(key);
                key++;
                k--;
            }
            if(k!=0) {
                return false;
            }
        }
        return true;
    }
}