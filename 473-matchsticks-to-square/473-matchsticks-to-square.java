class Solution {
    public boolean makesquare(int[] matchsticks)
    {
         if(matchsticks.length<4)
                 return false;
        int sum = 0;
            
        for(int i : matchsticks) 
                sum+=i;
       
            if(sum%4!=0)
                
                return false;
            
        int[] ans = new int[]{sum/4,sum/4,sum/4,sum/4};
            
        Arrays.sort(matchsticks);
            
        return make(matchsticks,sum, ans, matchsticks.length-1);
    }
    
    boolean make(int[] arr,int sum,int[] ans,int idx)
    {
        if(idx==-1)
        {
            return ans[0]==ans[1] && ans[1]==ans[2] && ans[2]==ans[3];
        }
        
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]>=arr[idx])
            {
                ans[i] -= arr[idx];
                    
                if(make(arr,sum,ans,idx-1)) 
                        
                        return true;
                ans[i] += arr[idx];
            }
        }
        return false;
    }
    }
