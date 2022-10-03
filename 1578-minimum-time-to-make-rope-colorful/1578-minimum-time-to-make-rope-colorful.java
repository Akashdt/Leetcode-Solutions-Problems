class Solution {

    public int minCost(String colors, int[] neededTime)
    {
        int i = 0, ans = 0;
            
        int n = colors.length();
            
        while (i < n) 
        {
            int j = i + 1;
            int max = neededTime[i];
            int sum = max;

            while (j < n && colors.charAt(j) == colors.charAt(i)) 
            {
                sum += neededTime[j];
                    
                max = Math.max(max, neededTime[j]);
                j++;
            }
                
            ans += sum - max;
            i = j;
        }

        return ans;
    }
}
