class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
         int count=0;
        int len = properties.length;
        Arrays.sort(properties,(a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        int max =properties[len-1][1];
        
        
        for(int i=len-1; i>=0; i--){
            
            if(properties[i][1]<max){
                 count++;
            }
               
            else{
                 max=Math.max(properties[i][1],max);
            }
           
        }
        return count;
    }
}