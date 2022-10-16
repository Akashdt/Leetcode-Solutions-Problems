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
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] a) {
        // code here
         TreeSet<Integer>t=new TreeSet<>();
       ArrayList<Integer>res=new ArrayList<>();
       res.add(-1);
       t.add(a[n-1]);
       for(int i=n-2;i>=0;i--){
           if(t.higher(a[i])!=null){
               res.add(t.higher(a[i]));
           }
           else{
               res.add(-1);
           }
           t.add(a[i]);
       }
       Collections.reverse(res);
       return res;
    }
}
        
