//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String str, int k)
    {
            HashMap<Character,Integer> hs=new HashMap<>();

        

        int start=0;

        int end=0;

        int maxFreq=0;

        int maxSubString=0;

        

        while(end<str.length())

        {

            char ch=str.charAt(end);

            hs.put(ch,hs.getOrDefault(ch,0)+1);

            

            maxFreq=Math.max(maxFreq,hs.get(ch));

            

           if(end-start+1-maxFreq>k)

            {

                char c=str.charAt(start);

                hs.put(c,hs.get(c)-1);

                if(hs.get(c)==0)

                 hs.remove(c);

                start++;

            }

            

            maxSubString=Math.max(maxSubString,end-start+1);

            end++;

        }

        return maxSubString;

        
    }
}