class Solution {
    public boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) {
return false;
}
if (s.length() == 0) {
return true;
}
HashMap<Character, Character> map = new HashMap();
HashSet values = new HashSet();
for (int i = 0; i < s.length(); i++) {
if (!map.containsKey(s.charAt(i))) {
if (values.contains(t.charAt(i))) {
return false;
}
map.put(s.charAt(i), t.charAt(i));
values.add(t.charAt(i));
} else {
if (map.get(s.charAt(i)) != t.charAt(i)) {
return false;
}
}
}
return true;  
    }
}