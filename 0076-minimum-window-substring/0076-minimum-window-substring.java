class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if(t.length()>n) return "";

        int counter=0, i=0, stri=0, strj=n; //counter is for chars counter not frequence , freq is managed by hashmap so counter will only increase when frequece of char is found all or extar means in map it is 0 or <0.

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int tchars = map.size();
          System.out.println(map);
        
        for(int j=0;j<n;j++){
            char c = s.charAt(j);

            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) counter++;
            }

            while(counter==tchars){
                if(j-i<strj-stri){
                    stri = i;
                    strj = j;
                }

                char c1 = s.charAt(i);

                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1)+1);

                    if(map.get(c1)==1) counter--;
                }
                i++;
            }
        }

        return (strj==n)?"":s.substring(stri, strj+1);
 
    }
}