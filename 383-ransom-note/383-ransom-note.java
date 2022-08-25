class Solution {
    public boolean canConstruct(String r, String m) {
    
            int[] f = new int[26];             
    
    for(int i=0;i<m.length();i++)
    {   
        int c = m.charAt(i)-'a';
        f[c]++;
    }
    for(int i=0;i<r.length();i++)
    { 
            
        int c = r.charAt(i)-'a';
        f[c]--;
    }
 
    for(int i=0;i<26;i++)
    {
        if(f[i]<0)
        {                        
            return false;
        }
           
    }
            return true;
    }
}