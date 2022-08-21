class Solution {

    public int[] movesToStamp(String stamp, String target) 
    {
        char[] st = stamp.toCharArray();
            
        char[] tg = target.toCharArray();
        int count = 0;
            
        int len = target.length();
            
        boolean[] visited = new boolean[len];
            
        List<Integer> list = new ArrayList<Integer>();
        while (count != len) {
            boolean didChange = false;
            for (int ind = 0; ind <= (tg.length - st.length); ind++)
            {
                if (check(ind, st, tg) && !visited[ind])
                {
                    didChange = true;
                    visited[ind] = true;
                    count = replace(ind, st, tg, visited, count);
                    list.add(ind);
                }
            }
           if (!didChange) 
           {
                   return new int[0];
           }
        }
        int[] ans = new int[list.size()];
        int ansL = ans.length;
            
        for (int ind = 0; ind < ansL; ind++)
        {
            ans[ansL - ind - 1] = list.get(ind);
        }
        return ans;
    }

    public int replace(int ind, char[] st, char[] tg, boolean[] visited, int count) {
        for (int i = ind; i < ind + st.length; i++)
        {
            if (tg[i] != '?') 
            {
                count++;
            }
                
            tg[i] = '?';
        }
        
            return count;
    }

    public boolean check(int ind, char[] st, char[] tg)
    {
        for (int i = ind; i < ind + st.length; i++) 
        {
            if (tg[i] != st[i - ind] && tg[i] != '?') 
            {
                return false;
            }
        }
        return true;
    }
}
