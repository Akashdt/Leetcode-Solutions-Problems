class Solution {
    public int candy(int[] ratings)
    {
         if(ratings.length==1)
         {
            return 1;
        }
        int[] cand = new int[ratings.length];
        cand[0] = 1;
        for(int i=1; i<ratings.length; i++)
        {
            if(ratings[i-1]<ratings[i])
            {
                cand[i] = cand[i-1] + 1;
            } 
                else 
            {
                cand[i] = 1;
            }
        }
       
            
        for(int i= ratings.length-1; i>0; i--)
        {
            if(ratings[i-1]>ratings[i])
            {
                cand[i-1] = Math.max(cand[i-1], cand[i]+1);
            }
        }
        
        int count = 0;
        for(int candy : cand)
        {
            count += candy;
        }
        return count;
    }
}