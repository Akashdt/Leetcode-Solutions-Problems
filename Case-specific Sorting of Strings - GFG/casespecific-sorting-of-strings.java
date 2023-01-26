//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
       int len=str.length();
        int sortl[]=new int[26];
        int sortu[] = new int[26];
        for(int i=0;i<len;i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z')
            sortl[str.charAt(i)-'a']++;
            else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
            sortu[str.charAt(i)-'A']++;
        }
        
        StringBuffer ans = new StringBuffer();
        
        for(int i=0;i<len;i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                int z=0;
                while(z<26&&sortl[z]==0)z++;
                if(z!=26){
                    ans.append((char)('a'+z));
                    sortl[z]--;
                }
                
            }
            else{
                int z=0;
                while(z<26&&sortu[z]==0)z++;
                if(z!=26){
                    ans.append((char)('A'+z));
                    sortu[z]--;
                }
        }
        
    }
    return ans.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends