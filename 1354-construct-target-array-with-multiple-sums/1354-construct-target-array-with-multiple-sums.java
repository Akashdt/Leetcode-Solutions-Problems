class Solution {
    public boolean isPossible(int[] target) {
         int n = target.length;
        
        if (n == 1) return target[0] == 1;
        
       
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        
        long totalSum = 0;
        for(int i = 0; i < n; i++)
        {
            totalSum += target[i];
            
            
            if(target[i] == 1) continue;
            
            maxHeap.add(target[i]);
        }
        
        
        while (!maxHeap.isEmpty()) 
        {
            int largest = maxHeap.remove();
        
           
            long remainingSum = (totalSum - largest);
            
            if(remainingSum == 1) return true;
            
          
            if(remainingSum >= largest) return false;
            
            int newLargest = (int)(largest % remainingSum);
            
          
            if(newLargest < 1) return false;
            
      
            if(newLargest > 1)
                maxHeap.add(newLargest);
            
            totalSum = totalSum  - largest + newLargest;
        }
        
        return true;
    }
}