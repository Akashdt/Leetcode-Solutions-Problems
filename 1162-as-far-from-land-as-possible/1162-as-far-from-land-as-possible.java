class Solution {
    public int maxDistance(int[][] grid) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int dir[] = {1,0,-1,0,1};
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1){
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int distance = 0;

        while(queue.size() > 0){

            int size = queue.size();
            while(size-- > 0){
                Pair<Integer, Integer> pair = queue.remove();
                int row = pair.getKey();
                int col = pair.getValue();
                visited[row][col] = true;
                for(int i = 0; i < 4; i++){
                    int newRow = row + dir[i];
                    int newCol = col + dir[i+1];
                    if(check(newRow, newCol, grid, visited)){
                        queue.add(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }

            }
            if(queue.size() > 0)
                distance++;
        }
        return distance == 0 ? -1 : distance;
    }
    public boolean check(int row, int col, int grid[][], boolean vis[][]){
        int m = grid.length;
        int n = grid[0].length;
        if(row >= 0 && row < m && col >= 0 && col < n){
            if(grid[row][col] == 0 && vis[row][col] == false) return true;
        }
        return false;
    }
}