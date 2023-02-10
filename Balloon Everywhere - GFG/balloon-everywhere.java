//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
         int a=0;

        int b=0;

        int l=0;

        int o=0;

        int n=0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == 98)

                b++;

            if(s.charAt(i) == 97)

                a++;

            if(s.charAt(i) == 108)

                l++;

            if(s.charAt(i) == 111)

                o++;

            if(s.charAt(i) == 110)

                n++;

        }

        int balloon=0;

        int flag;

        int k=0;

        int m=0;

        int p=0;

        if(l<=o)

            flag =1;

        else

            flag =0;

        if(b<=a && b<=n)

            k=1;

        else if(a<=b && a<=n)

            m=1;

        else

            p=1;

        if(flag==1){

            if(k==1){

                int c1 = l/2;

                if(c1<=b)

                    balloon = c1;

                else

                    balloon = b;

            }        

            

            if(m==1){

                int c2 = l/2;

                if(c2<=a)

                    balloon = c2;

                else

                    balloon = a;

            }

            if(p==1){

                int c3 = l/2;

                if(c3<=n)

                    balloon = c3;

                else 

                    balloon = n;

            }

        }

        else{

            if(k==1){

                int c4 = o/2;

                if(c4<=b)

                    balloon = c4;

                else

                    balloon = b;

            }

            if(m==1){

                int c5 = o/2;

                if(c5<=a)

                    balloon = c5;

                else

                    balloon = a;

            }

            if(p==1){

                int c6 = o/2;

                if(c6<=n)

                    balloon = c6;

                else

                    balloon = n;

            }

        }

     

        return balloon;
    }
}