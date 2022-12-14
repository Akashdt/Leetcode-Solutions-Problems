//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
       
       Vector<Integer> vector = new Vector<>();
       int maxl=0,maxr=0,msf=0,meh=0,s=0;
       
       for(int i=0;i<str.length();i++){
           meh += (str.charAt(i)=='0')?1:-1; 
           if(msf<meh){
               msf=meh;
               maxl=s;
               maxr=i;
           }
           if(meh<0){
               meh=0;
               s=i+1;
           }
       }

       if((maxl==0|| maxr==0) && msf==0){
           vector.add(-1);
           return vector;
       }
       vector.add(maxl+1);
       vector.add(maxr+1);
       
       return vector;
   }
}