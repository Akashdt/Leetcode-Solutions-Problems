class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap();
        int result = 0;
        
        for(String word:words) {
            String rev = reverse(word);
            if(map.containsKey(rev)) {
                result += 4;
                map.put(rev,map.get(rev)-1);
                if(map.get(rev) == 0) {
                    map.remove(rev);
                }
            } else {
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        
        for(String str:map.keySet()) {
              if(str.charAt(0) == str.charAt(1)) {
                  result += 2;
                  break;
              }
        }
        return result;
    }
    
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    }
