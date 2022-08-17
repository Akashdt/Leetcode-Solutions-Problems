class Solution {
    public int uniqueMorseRepresentations(String[] words) {
       char[] total = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < total.length; i++) {
            map.put(total[i], codes[i]);
        }
        
        Set<String> set = new HashSet<>();
        for(String i:words){
            String st = "";
            for(char j:i.toCharArray()){
                st += map.get(j);
            }
            set.add(st);
        }
        return set.size();  
    }
}