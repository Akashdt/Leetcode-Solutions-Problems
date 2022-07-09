class Solution {
    public int maxResult(int[] nums, int k) 
    {
             PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        int n = nums.length ;
        if(n==1)
                
            return nums[0];
            
        q.add(new int[]{0, nums[0]}) ; 
        for(int i = 1 ; i< n-1 ; i++)
        {
            while(!q.isEmpty() && q.peek()[0] < i-k )
                q.poll();
             q.add(new int[]{i, nums[i] + q.peek()[1]});
        }
            
        while(!q.isEmpty() && q.peek()[0] < (n-1)-k )
            
                q.poll();
            
        return nums[n-1] + q.peek()[1];
    }
}