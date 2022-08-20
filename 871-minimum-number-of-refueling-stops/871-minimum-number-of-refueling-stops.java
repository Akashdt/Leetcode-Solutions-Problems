class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) 
    {
         int i=0, currmilepos=0, currfuel=startFuel, anscount=0;
            
        
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a,b)->(b-a));
        
        while(true)
        {
            if(currmilepos+currfuel>=target)
            {
                return anscount;
            }
            else
            {
                     currmilepos += currfuel;
                         anscount++;
            }
           
            
            while(i<stations.length && stations[i][0]<=currmilepos)
            {
                maxpq.add(stations[i++][1]);
            }
            
            if(maxpq.size()==0)
            {
                return -1;
            }
            
            currfuel = maxpq.poll();
        }
        
    }
}