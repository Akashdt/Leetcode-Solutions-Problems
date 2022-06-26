class Solution {
    public int maxScore(int[] arr, int k) 
    {
         int sum= 0, window = 0;
            
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
                
            if(i< arr.length - k) 
                    
            {
                    window += arr[i];
            }
        }
        int max = sum - window;
        for(int i = arr.length - k; i < arr.length; i++)
        {
            window += arr[i] - arr[i - arr.length + k];
            max = Math.max(max, sum- window);
        }
        return max;
    }
}