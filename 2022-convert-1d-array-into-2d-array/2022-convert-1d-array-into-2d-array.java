class Solution {
    public int[][] construct2DArray(int[] arr, int r, int c)
    {
        if(r*c != arr.length)
        {
                return new int[0][0];
        }
       
        int ans[][] = new int[r][c];
        
      
        int count = 0;
     
        for(int i= 0;i <r; i++)
        {
            for(int j =0; j<c; j++)
            {
                ans[i][j] = arr[count++];
				
            }
        }

        return ans;
    }
}