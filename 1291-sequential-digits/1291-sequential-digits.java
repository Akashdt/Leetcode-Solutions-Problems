class Solution {
    public List<Integer> sequentialDigits(int low, int high) 
    {
         List<Integer> ans = new ArrayList();
        int s = String.valueOf(low).length(), e = String.valueOf(high).length();
        
        String str = "123456789";
            
        for(int c=s; c<= e; c++)
        {
            for(int i=0, j=c; i<j && j<=9; i++, j++)
            {
                String tmp = str.substring(i, j);
                    
                int num = Integer.parseInt(tmp);
                    
                if(num < low)
                    
                        continue;
                if(num > high)
                   
                        break;
                ans.add(num);
            }
        }
        return ans;
    }
}