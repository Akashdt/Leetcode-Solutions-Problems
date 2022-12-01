class Solution {
    public boolean halvesAreAlike(String s) {
        int c1 = 0;
        int c2 = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring(s.length()/2, s.length());
        for(int i = 0 ; i < s1.length() ; i++) {
            if((set.contains(s1.charAt(i)))) c1++;
        }
        for(int i = 0 ; i < s2.length() ; i++) {
            if((set.contains(s2.charAt(i)))) c2++;
        }
        return (c1 == c2) ? true : false;
    }
}