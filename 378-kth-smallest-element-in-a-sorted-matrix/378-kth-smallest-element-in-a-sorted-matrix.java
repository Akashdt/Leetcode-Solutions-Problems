class Solution {
    public int kthSmallest(int[][] m, int k) 
    {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0; i<m.length; i++)
        {
            for(int j = 0; j<m[i].length; j++)
            {
                p.add(m[i][j]);
            }
        }
        for(int i = 0; i<k-1; i++)
        {
            p.poll();
        }
        return p.peek();
    }
}