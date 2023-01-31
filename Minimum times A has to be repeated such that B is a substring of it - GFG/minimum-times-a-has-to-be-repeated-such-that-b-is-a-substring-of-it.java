//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String a, String b) {
        // code here
        int temp = b.length()/a.length();
        if(b.length()%a.length() != 0){
            temp+= 1;
        }
        int temp2 = temp +1;
        String c = "";
        for (int i = 0; i < temp; i++) {
            c += a;
        }

        String d = "";
        for (int i = 0; i < temp2; i++) {
            d += a;
        }

        if(c.contains(b)){
            return temp;
        } else if(d.contains(b)){
            return temp2;
        }else{
            return -1;
        }
    }
};