//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String S, String W){
         int ans=0;

        byte[] visit = new byte[S.length()];

        for(int i=0;i<=S.length()-W.length();i++) {

            int k=0;

            for(int j=0;j<S.length();j++) {

                if(S.charAt(j)==W.charAt(k) && visit[j]==0) {

                    k++;

                    visit[j]=1;

                }

                if(k>=W.length()) break;

            }

            if(k>=W.length()) ans++;

        }

        return ans;
    }
}