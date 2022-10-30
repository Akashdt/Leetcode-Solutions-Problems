class Solution {
    public String kthLargestNumber(String[] nums, int k) 
    {
          PriorityQueue<String>pq = new PriorityQueue<>((a,b)->
                                                        {
            return a.length()!= b.length()?
                a.length()- b.length(): a.compareTo(b);
        });
            
        for(String s: nums) 
                
                pq.add(s);
        
        while(pq.size()>k)
                
          
                pq.remove();
            
        return pq.peek();
    }
}