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
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String s, int[] p) {
           int cnt=0;

        for(int i=1;i<N;i++){

            if(s.charAt(i)==s.charAt(i-1)) cnt++;

        }

        char[] ch=s.toCharArray() ;

        int i=0;

        

        while(i<N&&cnt!=0)

        {

            if(ch[p[i]]!='?')

            {

                if((p[i]+1)<N&&ch[p[i]]==ch[p[i]+1])

                cnt--;

            

                if((p[i]-1)>=0&&ch[p[i]]==ch[p[i]-1])

                cnt--;

            }

            ch[p[i]]='?';

            i++;

        }

        return i;

    }
}
        
