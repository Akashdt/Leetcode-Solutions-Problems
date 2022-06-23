class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i: nums) 
        {
            minHeap.add(i);
            if (minHeap.size() > k)
            {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}