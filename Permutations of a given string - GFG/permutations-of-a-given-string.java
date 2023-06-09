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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String s) {
        // Code here
        int n=s.length();
        int m=n;
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        //String str="";
        ArrayList<String> arr=new ArrayList<String>();
       ArrayList<Character> ar=new ArrayList<Character>();
        for(int i=0;i<n;i++){
            ar.add(s.charAt(i));
        }
        Collections.sort(ar);
        s="";
        for(int i=0;i<ar.size();i++){
            s+=ar.get(i);
        }
        ar.clear();
        
        
        for(int i=0;i<f;i++){
            String ans=helper(s,arr,i);
            if(arr.contains(ans)){
                continue;
            }
            arr.add(ans);
        }
        return arr;
    }
    public String helper(String s,ArrayList<String> arr,int k){
        int fact=1;
        String ans="";
        ArrayList<Character> h=new ArrayList<Character>();
        h.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            fact*=i;
            h.add(s.charAt(i));
        }
        
        while(true){
            ans+=h.get(k/fact);
            h.remove(k/fact);
            if(h.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/h.size();
        }
        return ans;
    }
}

