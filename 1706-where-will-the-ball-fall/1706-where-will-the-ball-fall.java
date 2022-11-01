class Solution {
   public int[] findBall(int[][] grid) { 
 int[] res = new int[grid[0].length];
        
        for(int i = 0; i < res.length;i++){
            res[i] = traverse(0,i,grid);
        }
        
        return res;
    }
private int traverse(int i, int j, int[][] grid){
    if(grid[i][j] == 1){
        if(j == grid[0].length - 1){
            return -1;
        }
        if(grid[i][j + 1] == -1){
            return -1;
        }
        if(i == grid.length - 1){
            return j + 1;
        }
        
        return traverse(i + 1, j + 1, grid);
    }else{
        if(j == 0){
            return -1;
        }
        if(grid[i][j - 1] == 1){
            return -1;
        }
        if(i == grid.length - 1){
            return j - 1;
        }
        
        return traverse(i + 1, j - 1, grid);
    }
}
}