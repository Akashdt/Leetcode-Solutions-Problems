//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean res=false;
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<Integer>[] a = new ArrayList[N+1];
        
        for(int i=0;i<=N;i++)
        {
            a[i]=new ArrayList<Integer>();
        }
        for(ArrayList<Integer> x:Edges)
        {
            a[x.get(0)].add(x.get(1));
            a[x.get(1)].add(x.get(0));
        }
        
        for(int i=1;i<=N;i++){
        isPresent(a,i,0,new int[N+1]);
        if(res)
        return true;
        }
        return res;
    }
    
    private void isPresent(ArrayList<Integer>[] a,int x,int c,int[] temp)
    {
        if(c==a.length-1)
        {
            res=true;
            return;
        }
        for(int y:a[x]){
            if(temp[y]!=1)
            {
            temp[y]++;
            isPresent(a,y,c+1,temp);
            temp[y]--;
            }
        }
    }
} 