class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) 
    {
        Arrays.sort(horizontalCuts);
            
        Arrays.sort(verticalCuts);
        
            
        int max = horizontalCuts[0];
            
        for(int i=1;i<horizontalCuts.length;i++)
                
            max = Math.max(horizontalCuts[i]-horizontalCuts[i-1],max);
            
        max = Math.max(h-horizontalCuts[horizontalCuts.length-1],max);
        
            
        int maxv = verticalCuts[0];
        for(int i=1;i<verticalCuts.length;i++)
            maxv = Math.max(verticalCuts[i]-verticalCuts[i-1],maxv);
        maxv = Math.max(w-verticalCuts[verticalCuts.length-1],maxv);
        
       
        return (int)(1L*max*maxv %1000000007);
    }
}