class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        String key = s1+":"+s2;
        if(memo.containsKey(key)) return memo.get(key);
        if(s1.equals(s2)) return true;
        if(!freq(s1).equals(freq(s2))){ memo.put(key, false); return false;}
        // if s1 = [x].... && s2 = [x]....
        // or s1 = [x].... && s2 = ....[x]
        // then the scrambling may be possible
        int n = s1.length();
        boolean ans = false;
        for(int i=0;i<n-1;i++){
            String x1 = s1.substring(0, i+1);
            String x2s = s2.substring(0, i+1);
            String x2l = s2.substring(n-1-i);
            if(freq(x1).equals(freq(x2s))){
                ans = (isScramble(s1.substring(i+1), s2.substring(i+1)) && isScramble(x1, x2s));
            }
            if(freq(x1).equals(freq(x2l))){
                ans = ans | (isScramble(s1.substring(i+1), s2.substring(0, n-1-i)) && isScramble(x1, x2l));
            }
            if(ans){
                memo.put(key, ans);
                return ans;
            }
        }
        memo.put(key, ans);
        return ans;
    }
    String freq(String s){
        int[] f = new int[26];
        for(char c:s.toCharArray()){
            f[c-'a']++;
        }
        return Arrays.toString(f);
    }
}