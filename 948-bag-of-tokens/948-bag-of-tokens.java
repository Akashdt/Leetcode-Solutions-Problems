class Solution {
    public int bagOfTokensScore(int[] a, int p) {
         Arrays.sort(a);
            
        int score=0;
            
            int ans=0;
            
        int j=a.length-1;
            
        for(int i=0;i<=j;)
        {
            
            if(p>=a[i])
            {
                score++;
                p-=a[i];
                ans=Math.max(score,ans);
                i++;
            }
                else if(score>=1)
                {
              
                score--;
                p+=a[j];
                j--;
            }
                else break;
        }
        return ans;
    }
}