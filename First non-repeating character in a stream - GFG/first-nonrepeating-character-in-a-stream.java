//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        StringBuilder str = new StringBuilder();
        char[] arr = A.toCharArray();
        int[] repeats = new int[26];
        ArrayDeque<Character> q = new ArrayDeque<>();
        // q.addLast(arr[0]);
        // repeats[arr[0]-'a']++;
        for(char c:arr){
            if(repeats[c-'a']<1){
                if(!q.isEmpty()){
                    str.append(q.peekFirst());
                }
                else str.append(c);
                q.addLast(c);
                repeats[c-'a']++;
            }
            else{
                repeats[c-'a']++;
                while(!q.isEmpty()&&repeats[q.peekFirst()-'a']>1)q.removeFirst();
                if(q.isEmpty())str.append('#');
                else{
                    str.append(q.peekFirst());
                }
            }
        }
        return str.toString();
    }
}