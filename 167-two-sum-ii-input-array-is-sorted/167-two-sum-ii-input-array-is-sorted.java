class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
         int n = numbers.length;
            
        for(int i=0;i<n-1;i++)
        {
           int pos = Arrays.binarySearch(numbers,i+1,n,target-numbers[i]);
           
                if(pos>0) 
                        
                        return new int[]{i+1,pos+1};
        }
        return null;
    }
    }
