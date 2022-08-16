class Solution {
    public int firstUniqChar(String s) {
        int p=0;
int q=0;
int c=0;
for(int i=0;i<s.length();i++)
{
        p=s.indexOf(s.charAt(i));
        q=s.lastIndexOf(s.charAt(i));
        if(p==q)
        {
                break;
        }
else{
c++;
}
}
if(c==s.length())
return-1;
else
return q;
    }
}