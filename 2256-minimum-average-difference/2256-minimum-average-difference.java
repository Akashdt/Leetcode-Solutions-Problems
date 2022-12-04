class Solution {
    public int minimumAverageDifference(int[] nums) {
         long pre[]=new long[nums.length];
      long post[]=new long[nums.length];
     int min = Integer.MAX_VALUE;
     int ans =0;
      post[nums.length-1] = 0;
        pre[0] = nums [0];
      for  (int i =1;i<nums.length;i++){
          pre[i] = nums[i] + pre[i-1];
      }
      for(int i = nums.length-2; i>=0 ; i--){
          post[i] = post[i+1] + nums [i+1];
      }
      int sum =0;
        for  (int i =0;i<nums.length;i++){
            if((nums.length - 1 -i) >0)
       sum = Math.abs((int)Math.floor(pre[i]/(i+1)) -  (int)Math.floor(post[i]/(nums.length-1-i)));
       else 
        sum = (int)Math.floor(pre[i]/(i+1));

      if(sum < min){
          min = sum;
           ans = i;
      }
     
      }

      return ans;
    }
}