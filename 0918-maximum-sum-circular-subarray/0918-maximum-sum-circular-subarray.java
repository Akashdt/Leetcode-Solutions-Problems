class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      
        int max=Integer.MIN_VALUE, sum=0, total=0;
        for(int x:nums){
            sum+=x;
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
            total+=x; 
        }
        
        int max2=0;
        sum=0;
        for(int x:nums){
            max=Math.max(max,total+max2); 
                
            total-=x; 
                
            sum+=x; 
                    
            max2=Math.max(max2,sum); 
        }
        return max;
    }
}