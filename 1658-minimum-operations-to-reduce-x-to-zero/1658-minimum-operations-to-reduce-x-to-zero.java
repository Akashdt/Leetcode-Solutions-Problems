class Solution {
    public int minOperations(int[] arr, int x) {
     
          
        int sum = -x, n = arr.length;
            
        for (int num : arr) 
                sum+= num;
        
        if (sum < 0) 
                return -1;
        
        
        
        int currSum = 0, max = -1;
            
        for (int i=0, j=0; j<n; j++) 
        {
            
            currSum += arr[j];
            
            while (currSum > sum) 
            
            {
                currSum -= arr[i++];
            }
            
            if (currSum == sum)
            {
                max = Math.max(max, j-i+1);
            }
        }
        
        return max == -1 ? -1 : n - max;
    }
    }
        
