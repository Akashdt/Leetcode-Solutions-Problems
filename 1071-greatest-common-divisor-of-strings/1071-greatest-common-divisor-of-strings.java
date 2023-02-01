class Solution {
    public String gcdOfStrings(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(!(s1+s2).equals(s2+s1)){
            return "";
        }

        while(n!=0){
            int temp = n;
            n = m%n;
            m = temp;
        }

        return s2.substring(0,m);
       
    }
}