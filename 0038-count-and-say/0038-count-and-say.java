class Solution {
    public String countAndSay(int n) {
        
        if(n==1){
            String s = "1";
            return s;
        }
String s = countAndSay(n-1);

StringBuilder stringCount = new StringBuilder();
int count=1;

for(int i=1; i<s.length(); i++) {
if(s.charAt(i)==s.charAt(i-1)){
 count ++;
} else{
stringCount.append(count).append(s.charAt(i-1));
count=1;
}
}
stringCount.append(count).append(s.charAt(s.length()-1));
return stringCount.toString();

    }
}