class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
             
   PriorityQueue<Integer> min_heap=new PriorityQueue<>();  
          
        for(int i=0;i<heights.length-1;i++)
        {
            int diff=heights[i+1]-heights[i];  
            
            if(diff>0)
            {
                min_heap.add(diff);
            }
            
            if(min_heap.size()>ladders)
            {
                bricks-=min_heap.remove();
            }
            
            if(bricks<0)
            {  
                    
                return i;
            }
        }  
       return heights.length-1;
    }
}