class Solution {
    public List<String> removeAnagrams(String[] words) {
       Set<String> set = new HashSet<>();
        String prev="";
        List<String> result = new ArrayList<>();
        for(String word: words){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(!prev.equals(s))
                set.clear();
            if(!set.contains(s)){
                set.add(s);
                result.add(word);
                prev=s;
            }
        }
        return result; 
    }
}