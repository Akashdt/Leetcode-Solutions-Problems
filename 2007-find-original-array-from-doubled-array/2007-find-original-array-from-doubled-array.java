class Solution {
    public int[] findOriginalArray(int[] changed)
    {
   if(changed.length % 2 != 0) 
           
           return new int[0];
        
        Arrays.sort(changed);
            
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : changed)
        {
       
            if(!q.isEmpty() && val == q.peek())
               
                    q.poll();
            else
            {
                    q.offer(val*2);
                list.add(val);
            }
        }
        if(!q.isEmpty())
            return new int[0];
     
        int result[] = new int[list.size()];
        for(int i = 0; i < result.length; i++){
                
            result[i] = list.get(i);
        }
        return result;
    }
}