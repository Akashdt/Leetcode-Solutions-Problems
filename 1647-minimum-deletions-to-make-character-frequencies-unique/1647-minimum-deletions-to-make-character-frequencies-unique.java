class Solution {
    public int minDeletions(String s) 
    {
         int[] a=new int[26];
            
        for(int i=0;i<s.length();i++)
        {
           
                a[s.charAt(i)-'a']++;//counting no of each letter      
        }
            
        HashSet<Integer> f =new HashSet<>(); //set for storing the frequencies found
        
            int c=0; //for finding the number of deletions to make string with unique no of freqs.
            
        for(int i=0;i<a.length;i++)
        {
            while(a[i]!=0 && f.contains(a[i]))
            {
               a[i]--; //delete the matching freq
               c++; 
            }
            f.add(a[i]);//the new string after 1 deletion
        }
        return c;//ans count
    }
}