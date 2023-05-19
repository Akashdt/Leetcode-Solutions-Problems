class Solution {
    public boolean isBipartite(int[][] graph) 
    {
         int[] colors = new int[graph.length];
        
      
        for(int i=0; i<graph.length; i++) 
        {
           
            if(colors[i] == 0 && !hasEvenCycle(graph, colors, i, 1))
                return false;
        }
        
        return true;
    }
    
    
    public boolean hasEvenCycle(int[][] g, int[] colors, int node, int c) 
    {
        
        if(colors[node] != 0)
                
            return 
                colors[node] == c;
        
        colors[node] = c;
        
        for(int n : g[node]) 
        {
            if(!hasEvenCycle(g, colors, n, -c))
                return false;
        }
        
        return true;
        
    }
}