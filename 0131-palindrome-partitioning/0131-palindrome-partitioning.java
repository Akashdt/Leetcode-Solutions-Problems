class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),0,s);
        return res; 
    }

    public void dfs(List<List<String>> res,List<String> list, int idx,String s)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(list));
            return;
        }
      
        for(int i=idx;i<s.length();i++)
        {
            String curStr = s.substring(idx,i+1);
            if(!validPalindrome(curStr))
            {
                continue;
            }
            list.add(curStr);
            dfs(res,list,i+1,s);
            list.remove(list.size()-1);
        }
    }

    public boolean validPalindrome(String palindrome)
    {
        int start = 0;
        int end = palindrome.length()-1;
        char[] strArr = palindrome.toCharArray();

        while(start<end)
        {
            if(strArr[start]!=strArr[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    
    }
}
