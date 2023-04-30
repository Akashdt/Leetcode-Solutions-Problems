//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
       int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++)
       {
           max=Math.max(max,interval[i][1]);
       }
       int temp[]=new int[max+2];
       for(int i=0;i<n;i++)
       {
           temp[interval[i][0]]=temp[interval[i][0]]+1;
           temp[interval[i][1]+1]=temp[interval[i][1]+1]-1;
       }
       
       int ans=-1;
       for(int i=1;i<=max+1;i++)
       {
           temp[i]=temp[i]+temp[i-1];
           if(temp[i]>=k)
           {
               ans=i;
           }
       }
      // System.out.println(Arrays.toString(temp));
       return ans;
    }
}