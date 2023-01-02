class Solution {
    public boolean detectCapitalUse(String word) {
        String str1=word.toUpperCase(),str2=word.toLowerCase();
        char ch1=word.charAt(0);
        boolean c1=Character.isUpperCase(ch1);
        String a1=(word.substring(1).toLowerCase());
        if(word.equals(str1)==true || word.equals(str2)==true || (c1==true && a1.equals(word.substring(1)))==true)
        {
            return true;
        }
        return false;
    }
}