class Solution {
    public int maxProfit(int[] prices)
    {
        int l = Integer.MAX_VALUE;
        int o = 0;
        int p = 0;
        
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < l)
            
            {
                l = prices[i];
            }
            p = prices[i] - l;
            if(o< p){
                o = p;
            }
        }
        return o;
    }
}