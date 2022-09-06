class Solution {
    public int numIslands(char[][] grid)
    {
         int count=0;
            
        int n = grid.length;
            
        int m = grid[0].length;
            
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == '1') 
                {
                    countIsland(i, j, n, m, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void countIsland(int i, int j, int n, int m, char[][] grid)
    {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1') 
            
                return ;
        grid[i][j] = '0';
        
        countIsland(i+1, j, n, m, grid);
        countIsland(i-1, j, n, m, grid);
        countIsland(i, j+1, n, m, grid);
        countIsland(i, j-1, n, m, grid);
    }
    }