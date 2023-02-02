class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int N = words.length;
        
        for(int i=0; i<N-1;i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];
            
            if(bigger(s1,s2,order))
                return false;
            
        }
        return true;
    }
    private boolean bigger(String s1, String s2,String order)
    {
        int n = s1.length();
        int m = s2.length();
        
        int l = Math.min(n,m);
        
        for(int i=0;i<l;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                return order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i));
            }
        }
        return n>m;
    }
}