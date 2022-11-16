//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {

        // code here

        int min;

        int max;

        int count = 0;

        int[] freq = new int[26];

        for (int j = 0; j < s.length(); j++) {

            for (int i = j; i < s.length(); i++) {

                freq[s.charAt(i)-'a']++;

                int[] beauty = findBeauty(freq);

                min = beauty[0];

                max = beauty[1];

                if (max > 1){

                    count = count + (max-min);

                }

            }

            freq = new int[26];

        }

        return count;

    }

 

public static int[] findBeauty(int[] freq){

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;

        for (int j : freq) {

            if (j > 0) {

                min = Math.min(min, j);

                max = Math.max(max, j);

            }

        }

        int[] value = new int[2];

        value[0] = min;

        value[1] = max;

        return value;

    }
}
        
