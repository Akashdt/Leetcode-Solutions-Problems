class Solution {
public:
    int countVowelSubstrings(string word) {
        int n=word.length();
int ans=0;
for(int i=0;i<n;i++)
{
int cnta=0,cnte=0,cnti=0,cnto=0,cntu=0;
int j=i;
while(j<n)
{
if(word[j]=='a')
cnta++;
else if(word[j]=='e')
cnte++;
else if(word[j]=='i')
cnti++;
else if(word[j]=='o')
cnto++;
else if(word[j]=='u')
cntu++;
else{
break;
}
if(cnta&&cnte&&cnti&&cnto&&cntu)
{
ans++;
}

            j++;
        }
    }
    return ans;
    }
};