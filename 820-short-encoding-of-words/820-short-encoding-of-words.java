class Solution {
    public int minimumLengthEncoding(String[] words)
    {
        Set<String> w= new HashSet(Arrays.asList(words));
        for (String word: words) 
        {
            for (int k = 1; k < word.length(); ++k)
                w.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: w)
            ans += word.length() + 1;
        return ans; 
    }
}