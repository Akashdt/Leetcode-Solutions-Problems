class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int count = 0;
        StringBuilder str = new StringBuilder();
        int size = (int)Math.min(word1.length(),word2.length());
        System.out.println(size);
        while(i < size || j < size){
            if(count % 2 == 0){
                str.append(word1.charAt(i));
                i++;
                count++;
            }
            else{
                str.append(word2.charAt(j));
                j++;
                count++;
            }
        }
        System.out.println(i);
        System.out.println(j);
        if(i != word1.length()){
            str.append(word1.substring(i, word1.length()));
        }
        if(j != word2.length()){
            str.append(word2.substring(j, word2.length()));
        }

        return str.toString();
    }
}